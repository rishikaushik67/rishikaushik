package project.library.dataaccess;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import project.library.dataaccess.DataAccessFacade.Pair;
import project.library.model.Book;
import project.library.model.LibraryMember;
import project.library.model.Periodical;
import project.library.model.Publication;

public interface DataAccess {
//	public LibraryMember readLibraryMember(String memberId);
	
//	public void saveLibraryMember(String name, LibraryMember member);
	
	///////save methods
	public void saveNewMember(LibraryMember member) throws IOException;
	public void updateMember(LibraryMember member) throws IOException;
	
	//save new lendable item
	public void saveNewBook(Book book) throws IOException;
	public void saveNewPeriodical(Periodical periodical) throws IOException;
	
	//////read methods 
	public Publication readBooksMap(String bookId) throws ClassNotFoundException, IOException;
	public HashMap<Pair<String,Integer>, Periodical> readPeriodicalsMap(String bookId) throws ClassNotFoundException, IOException;
	public HashMap<String, LibraryMember> readMemberMap(String bookId) throws ClassNotFoundException, IOException;

	public void loadMemberMap(LibraryMember libraryMembers) throws IOException;
	public LibraryMember searchMember(String text) throws ClassNotFoundException, IOException;
	public void removePublicationFromStorage(String memberId, Object ob) throws IOException ;


}