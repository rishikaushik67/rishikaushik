package project.library.dataaccess;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import project.library.model.Book;
import project.library.model.LibraryMember;
import project.library.model.Periodical;
import project.library.model.Publication;

public class DataAccessFacade implements DataAccess {
	
	enum StorageType {
		BOOKS, PERIODICALS, MEMBERS;
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			
			+ "\\src\\project\\library\\dataaccess\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	private static HashMap<String,Book> books;
	private static HashMap<Pair<String, Integer>,Periodical> periodicals;
	private static HashMap<String, LibraryMember> members;
	String memberId ;
	
	////specialized lookup methods
	public LibraryMember searchMember(String memberId) throws ClassNotFoundException, IOException {
	
		return (LibraryMember)readFromStorage(memberId);
	}
	
	
	
	///////save methods
	//saveNewMember
	public void saveNewMember(LibraryMember member) throws IOException {
		saveToStorage(member.getMemberId(), member);	
	}
	
	public void updateMember(LibraryMember member) throws IOException {
		saveNewMember(member);
	}
	
	//save new lendable item
	public void saveNewBook(Book book) throws IOException {
		saveToStorage(book.getIsbn(), book);	
	}
	
	public void saveNewPeriodical(Periodical periodical) throws IOException {
		saveToStorage(periodical.getIssueNumber(), periodical);	
	}
	
	
	
	
	
	//////read methods that return full maps
	///// programming idiom: when saves are done, the corresponding map
	////  is updated, then saved to storage, so when a read is done
	////  it is not necessary to retrieve from storage -- just read
	////  the map provided in this class
	
	
	@SuppressWarnings("unchecked")
	public  Publication readBooksMap(String bookId) throws ClassNotFoundException, IOException {
		return (Publication) readPublicationFromStorage(bookId);
	}
	@SuppressWarnings("unchecked")
	public HashMap<Pair<String,Integer>, Periodical> readPeriodicalsMap(String periodicId) throws ClassNotFoundException, IOException {
		if(periodicals == null) {
			periodicals = (HashMap<Pair<String,Integer>, Periodical>) readFromStorage(
					periodicId);
		}
		return periodicals;
	}
	
//	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberMap(String memberId) throws ClassNotFoundException, IOException {
//		if(members == null||members.isEmpty()) {
			members = (HashMap<String, LibraryMember>) readFromStorage(memberId);
//		}
		return members;
	}
	
	
	/////load methods - these place test data into the storage area
	///// - used just once at startup  
	public  void loadMemberMap(LibraryMember member) throws IOException {
		saveToStorage(member.getMemberId(), member);
	}
	public  void loadBookMap(List<Book> bookList) {
		books = new HashMap<String, Book>();
		bookList.forEach(book -> books.put(book.getIsbn(), book));
//		saveToStorage(StorageType.BOOKS, books);
	}
	public  void loadPeriodicalsMap(List<Periodical> periodicalList) {
		periodicals = new HashMap<Pair<String, Integer>, Periodical>();
//		periodicalList.forEach(
//			p -> periodicals.put(new Pair<String,Integer>(p.getTitle(), p.getIssueNumber()), p));
//		saveToStorage(StorageType.PERIODICALS, periodicals);
	}
	public  void saveToStorage(String memberId, Object ob) throws IOException {
		String Dir="";
		if(ob instanceof Publication){
			 Dir="/publication";
		}
		
			ObjectOutputStream out = null;
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+Dir, memberId);
			System.out.println(path);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	

	public  void removePublicationFromStorage(String memberId, Object ob) throws IOException {
				
		 File file = new File(OUTPUT_DIR+"/publication/" + memberId);

         if(file.delete()){
        	
        	ObjectOutputStream out = null;
 			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+"/publicationIssued", memberId);
 			System.out.println(path);
 			out = new ObjectOutputStream(Files.newOutputStream(path));
 			out.writeObject(ob);
 			if(out != null) {
 				try {
 					out.close();
 				} catch(Exception e) {}
 			} 
         }
	}
	
	

	public  Object readFromStorage(String memberId) throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		Object retVal = null;
		
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, memberId);
			System.out.println(path);
			in = new ObjectInputStream(Files.newInputStream(path));
			System.out.println(in.toString());
			retVal = in.readObject();
		
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
		}
		return retVal;
	}
	
	public  Object readPublicationFromStorage(String publicationNumber) throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		Object retVal = null;
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR+"/publication", publicationNumber);
			System.out.println(path);
			in = new ObjectInputStream(Files.newInputStream(path));
			System.out.println(in.toString());
			retVal = in.readObject();
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		return retVal;
	}
		
	final static class Pair<S,T> implements Serializable{
		
		S first;
		T second;
		Pair(S s, T t) {
			first = s;
			second = t;
		}
		@Override 
		public boolean equals(Object ob) {
			if(ob == null) return false;
			if(this == ob) return true;
			if(ob.getClass() != getClass()) return false;
			@SuppressWarnings("unchecked")
			Pair<S,T> p = (Pair<S,T>)ob;
			return p.first.equals(first) && p.second.equals(second);
		}
		
		@Override 
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}
		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}
		private static final long serialVersionUID = 5399827794066637059L;
	}
}
