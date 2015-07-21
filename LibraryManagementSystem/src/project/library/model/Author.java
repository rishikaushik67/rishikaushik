package project.library.model;


public class Author extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String credentials;
	
	public Author(String firstName, String lastName, String phoneNumber,String credentials,Address address) {
		super(firstName, lastName, phoneNumber,address);
		this.credentials=credentials;
	}
}
