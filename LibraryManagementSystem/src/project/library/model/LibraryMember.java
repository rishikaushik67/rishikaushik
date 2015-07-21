package project.library.model;

import java.io.Serializable;
import java.util.List;

public class LibraryMember extends Person implements Serializable {
	private CheckoutRecord record = new CheckoutRecord();
	
	private String memberId;
	
	private String credentials;
	
	private LendableCopy copy;
	
	public void addCheckoutEntry(CheckoutRecordEntry entry) {
//		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry);
		
	}
	
	public LibraryMember(String firstName, String lastName, String phoneNumber,
			String memberId, Address address) {
		super(firstName, lastName, phoneNumber, address);
		this.memberId = memberId;
	}



	public LendableCopy getCopy() {
		return copy;
	}

	public void setCopy(LendableCopy copy) {
		this.copy = copy;
	}

	public CheckoutRecord getRecord() {
		return record;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getCredentials() {
		return credentials;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "Checkout record for library member " + super.getFirstName() + ": " + record;
	}
	
	public void setRecord(CheckoutRecord record) {
		this.record = record;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
