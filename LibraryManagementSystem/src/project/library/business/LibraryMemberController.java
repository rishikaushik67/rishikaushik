package project.library.business;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.library.dataaccess.DataAccess;
import project.library.dataaccess.DataAccessFacade;
import project.library.dataaccess.TestJavaDb;
import project.library.model.Address;
import project.library.model.CheckoutRecordEntry;
import project.library.model.LendableCopy;
import project.library.model.LibraryMember;

public class LibraryMemberController {

	@FXML
	private TextField memberId;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField street;
	@FXML
	private TextField city;
	@FXML
	private TextField state;
	@FXML
	private TextField telephoneNumber;
	@FXML
	private TextField zip;
	@FXML
	private TextField searchMemberId;
	@FXML
	private TableView<CheckoutRecordEntry> tableView;
	
	@FXML
	private TableColumn<CheckoutRecordEntry, String> titleColumn;
	
	@FXML
	private TableColumn<CheckoutRecordEntry, LocalDate> checkOutDateColum;
	
	@FXML
	private TableColumn<CheckoutRecordEntry, LocalDate> dueDateColumn;
	
	private Stage stage;
	
	private ObservableList<CheckoutRecordEntry> libraryMemberData = FXCollections.observableArrayList();
	
	
//	String insertAdress="";
	
	@FXML
	public void handleNewPerson(){
		
		/*Address address=new Address(street.getText(), city.getText(), state.getText(), zip.getText());
		LibraryMember member = new LibraryMember(firstName.getText(), lastName.getText(),
				telephoneNumber.getText(),memberId.getText(),address);
		System.out.println("Location of 'user.dir':\n  "+DataAccessFacade.OUTPUT_DIR);*/
		String handleNewPerson="insert into librarymember (memberid, firstname, lastname, telephone, addressid ) "
				+ "values('"+memberId.getText()+"','"+firstName.getText()+"',"+"'"+
				lastName.getText()+"',"+""+telephoneNumber.getText()+","+zip.getText()+")";	
		try {
			TestJavaDb db=new TestJavaDb();
			db.insertMember(handleNewPerson);
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Success");
			alert.setContentText("Member added successfully");
			alert.showAndWait();
			clearScreen();
		} catch (SQLException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Please check all the fields");
			alert.showAndWait();
			clearScreen();
			System.out.println(e.getMessage());
		}
	}
	
	private void clearScreen() {
		memberId.setText("");
		firstName.setText("");
		lastName.setText("");
		street.setText("");
		city.setText("");
		state.setText("");
		zip.setText("");
		telephoneNumber.setText("");
		
	}

	@FXML
	public void searchPersonInfo(){

		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/project/library/ui/LibraryMemberDetails.fxml"));
			Stage stage = new Stage();
			
	        stage.setTitle("MPP Library");
	        stage.setScene(new Scene(root, 600, 675));
	        stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void showPersonInfo(){

		DataAccess da = new DataAccessFacade();
		
		TestJavaDb db=new TestJavaDb();
//		System.out.println(da.readLibraryMember(libraryMember.getMemberId()));
		try {
			LibraryMember libraryMember=da.searchMember(memberId.getText());
			firstName.setText(libraryMember.getFirstName());
			lastName.setText(libraryMember.getLastName());
			street.setText(libraryMember.getAddress().getStreet());
			city.setText(libraryMember.getAddress().getCity());
			state.setText(libraryMember.getAddress().getState());
			telephoneNumber.setText(libraryMember.getPhoneNumber());
			zip.setText(libraryMember.getAddress().getZip());
			LendableCopy copy=libraryMember.getCopy();
			if(copy!=null){
			CheckoutRecordEntry checkoutRecordEntry=new CheckoutRecordEntry(copy, LocalDate.now(),
					LocalDate.now().plusDays(Long.parseLong(copy.getPublication().getMaxCheckOutLengh())));
			libraryMemberData.add(checkoutRecordEntry);
			tableView.setItems(libraryMemberData);
			titleColumn.setCellValueFactory(cellData->cellData.getValue().getCopy().getValue().getPublication().getTitle());
			checkOutDateColum.setCellValueFactory(cellData->cellData.getValue().getCheckoutDate());
			dueDateColumn.setCellValueFactory(cellData->cellData.getValue().getDueDate());
			}
		} catch (ClassNotFoundException | IOException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Please check the data entered");
			alert.showAndWait();
		}
	}
	
	@FXML
	
	public void updatePersonInfo(){
		DataAccess da = new DataAccessFacade();
		try {
			LibraryMember libraryMember=da.searchMember(memberId.getText());
			libraryMember.setFirstName(firstName.getText());
			libraryMember.setLastName(lastName.getText());
			libraryMember.setPhoneNumber(telephoneNumber.getText());
			Address address=new Address(street.getText(), city.getText(), state.getText(), zip.getText());
			libraryMember.setAddress(address);
			da.saveNewMember(libraryMember);
			
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Sucess");
			alert.setContentText("Periodical Added Sucessfully");
			alert.showAndWait();
		} catch (ClassNotFoundException | IOException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Please check all the fields");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void addPersonInfo(){
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/project/library/ui/LibraryMember.fxml"));
			stage = new Stage();
	        stage.setTitle("MPP Library");
	        stage.setScene(new Scene(root, 600, 675));
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
