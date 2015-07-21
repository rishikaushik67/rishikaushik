package project.library.business;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import project.library.dataaccess.DataAccess;
import project.library.dataaccess.DataAccessFacade;
import project.library.model.CheckoutRecordEntry;
import project.library.model.LibraryMember;

public class LibraryMemberEditController {


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
	
	
	//firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
//	private LibraryMember libraryMember;
	@FXML
	private void initialize() {
//		showPersonInfo();
	}
	@FXML
	public void showPersonInfo(){

		DataAccess da = new DataAccessFacade();
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
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    memberId.setText("12345");
		
		
	}

	
	@FXML
	public void updatePersonInfo(){
		DataAccess da = new DataAccessFacade();
		try {
			LibraryMember libraryMember=da.searchMember(memberId.getText());

			libraryMember.setFirstName(firstName.getText());
			libraryMember.setLastName(lastName.getText());
			libraryMember.setPhoneNumber(telephoneNumber.getText());
			da.updateMember(libraryMember);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		libraryMember.setFirstName(firstName.getText());
//		libraryMember.setFirstName(firstName.getText());
		
	}
	
}
