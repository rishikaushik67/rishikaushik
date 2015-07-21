
package project.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import project.library.dataaccess.DataAccessFacade;

public class CheckoutRecordEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectProperty<LendableCopy> copy;
	private ObjectProperty<LocalDate> checkoutDate;
	private ObjectProperty<LocalDate> dueDate;
	
	public CheckoutRecordEntry(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate){ 
		this.copy =new SimpleObjectProperty<LendableCopy>(copy);
		this.checkoutDate =new SimpleObjectProperty<LocalDate>( checkoutDate);
		this.dueDate =new SimpleObjectProperty<LocalDate>(dueDate) ;
	}
	public String toString() {
		return "[" + "checkoutdate:" + 
	        checkoutDate +
	        ", dueDate: " + dueDate+
	        ", publication: " + copy + "]";
	}
	public ObjectProperty<LocalDate> getDueDate() {
		return dueDate;
	}
	public ObjectProperty<LendableCopy> getCopy() {
		return copy;
	}
	public ObjectProperty<LocalDate> getCheckoutDate() {
		return checkoutDate;
	}
	
	
	
}
