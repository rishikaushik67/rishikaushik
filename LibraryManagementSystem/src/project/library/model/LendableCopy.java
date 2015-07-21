package project.library.model;

import java.io.Serializable;
import java.util.UUID;

public class LendableCopy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Publication publication;
	private UUID copyId; 
	
	public LendableCopy(Publication publication) {
		super();
		this.publication = publication;
	}
	public void setCopyId(UUID copyId) {
		this.copyId = copyId;
	}
	public String toString() {
		return publication.toString();
	}
	public Publication getPublication() {
		return publication;
	}
	
}
