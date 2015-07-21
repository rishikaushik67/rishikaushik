package project.library.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

abstract public class Publication implements Serializable {
	
	private static final long serialVersionUID = 2010893663327964921L;
	private String title;
	
	private List<LendableCopy> copy;

	private UUID copyId;
	
	private String maxCheckOutLengh;

	
	public Publication(String title, String maxCheckOutLengh) {
		super();
		this.title = title;
		this.maxCheckOutLengh = maxCheckOutLengh;
	}
	public StringProperty getTitle() {
		return new SimpleStringProperty(title);
	}
	public List<LendableCopy> getCopy() {
		return copy;
	}
	public void setCopy(List<LendableCopy> copy) {
		this.copy = copy;
	}
	
	public void addCopy(){
		copy.add(new LendableCopy(this));
	}
	public String getMaxCheckOutLengh() {
		return maxCheckOutLengh;
	}
	public void setMaxCheckOutLengh(String maxCheckOutLengh) {
		this.maxCheckOutLengh = maxCheckOutLengh;
	}

}
