package project.library.business;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import project.library.dataaccess.DataAccess;
import project.library.dataaccess.DataAccessFacade;
import project.library.model.Address;
import project.library.model.Author;
import project.library.model.Book;
import project.library.model.CheckoutRecordEntry;
import project.library.model.LendableCopy;
import project.library.model.LibraryMember;
import project.library.model.Periodical;
import project.library.model.Publication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LibraryPublicationController {
	
	@FXML
	private TextField title;
	@FXML
	private TextField titlePer;
	@FXML
	private TextField isbnNumber;
	@FXML
	private TextField issueNumberPer;
	@FXML
	private TextField authors;
	@FXML
	private TextField maxCheckOutLength;
	@FXML
	private TextField maxCheckOutLengthPer;
	@FXML
	private TextField memberId;
	
	@FXML
	public void addNewPublication(){
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/project/library/ui/AddPublication.fxml"));
			Stage stage = new Stage();
			stage.setTitle("MPP Library");
	        stage.setScene(new Scene(root, 900, 675));
	        stage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void addBook(){
		List<Book> books = new ArrayList<Book>();
		List<Author> authorsList=new ArrayList<>();
		/*if(authors.getText().contains(",")){
		StringTokenizer st2 = new StringTokenizer(authors.getText(), ",");
		while (st2.hasMoreElements()) {
			Address address=new Address(st2.nextToken(), st2.nextToken(), st2.nextToken(), st2.nextToken());
			authorsList.add(new Author(st2.nextToken(), st2.nextToken(), st2.nextToken(),
					st2.nextToken(), address));
		}
	}else{
		Address address=new Address(authors.getText(), authors.getText(), authors.getText(),authors.getText());
		authorsList.add(new Author(authors.getText(),authors.getText(),authors.getText(),
				authors.getText(), address));
	}
		books.add(new Book(title.getText(), isbnNumber.getText(), authorsList,
				maxCheckOutLength.getText()));
	*/	
		Book book=new Book(title.getText(), isbnNumber.getText(), authorsList,
				maxCheckOutLength.getText());
		try {
			new DataAccessFacade().saveNewBook(book);
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Sucess");
			alert.setContentText("Book Added Sucessfully");
			alert.showAndWait();
		} catch (IOException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Book Addition Failed");
			alert.showAndWait();
		}
		
		title.setText("");
		isbnNumber.setText("");
		maxCheckOutLength.setText("");
	}
	
	@FXML
	public void addPeriodical(){
		Periodical periodical=new Periodical(titlePer.getText(), issueNumberPer.getText(),
				maxCheckOutLengthPer.getText());
		try {
			new DataAccessFacade().saveNewPeriodical(periodical);
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Sucess");
			alert.setContentText("Periodical Added Sucessfully");
			alert.showAndWait();
		} catch (IOException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unable to Store Periodical");
			alert.showAndWait();
		}
		
		titlePer.setText("");
		issueNumberPer.setText("");
		maxCheckOutLengthPer.setText("");
	}
	
	@FXML
	public void checkOutRecord(){
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/project/library/ui/CheckoutRecord.fxml"));
			Stage stage = new Stage();
			stage.setTitle("CheckOut Record");
	        stage.setScene(new Scene(root, 900, 675));
	        stage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void checkOutPeriodical(){
		
		DataAccess da = new DataAccessFacade();
		LibraryMember libraryMember;
		try {
			libraryMember = da.searchMember(memberId.getText());
			Publication publication= da.readBooksMap(issueNumberPer.getText());
			LendableCopy copy=new LendableCopy(publication);
			if(publication==null){
				throw new NullPointerException();
			}
			libraryMember.setCopy(copy);
			da.saveNewMember(libraryMember);
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Sucess");
			alert.setContentText("Check Out Sucessfull");
			alert.showAndWait();
			issueNumberPer.setText("");
			title.setText("");
			if(publication!=null)
			da.removePublicationFromStorage(issueNumberPer.getText(),publication);
			
		} catch (ClassNotFoundException | IOException |NullPointerException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("CheckOutEntry not found ");
			alert.showAndWait();
			issueNumberPer.setText("");
			title.setText("");
		}
	}
	
	@FXML
	public void checkOutBook(){
		
		DataAccess da = new DataAccessFacade();
		LibraryMember libraryMember;
		try {
			libraryMember = da.searchMember(memberId.getText());
			Publication publication= da.readBooksMap(isbnNumber.getText());
			LendableCopy copy=new LendableCopy(publication);
			if(publication==null){
				throw new NullPointerException();
			}
			libraryMember.setCopy(copy);
			da.saveNewMember(libraryMember);
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Sucess");
			alert.setContentText("Check Out Sucessfull");
			alert.showAndWait();
			isbnNumber.setText("");
			
			if(publication!=null)
			da.removePublicationFromStorage(isbnNumber.getText(),publication);
			
		} catch (ClassNotFoundException | IOException |NullPointerException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("CheckOutEntry not found ");
			alert.showAndWait();
			isbnNumber.setText("");
			
		}
	}
}
