package project.library.model;

import java.io.Serializable;
import java.util.List;

public class Book extends Publication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private List<Author> authors;
	
	public Book(String title, String isbn, List<Author> authors,
			String maxCheckoutLength) {
		super(title, maxCheckoutLength);
		this.isbn = isbn;
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void addCopy(){
		super.addCopy();
	}
}
