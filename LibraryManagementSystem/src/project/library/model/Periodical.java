package project.library.model;

import java.io.Serializable;

public class Periodical extends Publication implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4119044948900180368L;

	private String issueNumber;
	
	
	public Periodical(String title,  String issueNumber,
			String maxCheckOutLength) {
		super(title, maxCheckOutLength);
		this.issueNumber = issueNumber;
	}

	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	
}
