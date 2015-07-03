package org.monster.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */

public class Books implements java.io.Serializable {

	// Fields

	private String isbn;
	private String title;
	private String publisherName;
	private Double price;
	private Date pubDt;

	// Constructors

	/** default constructor */
	public Books() {
	}
	/** full constructor */
	public Books(String isbn, String title, String publisherName, Double price,
			Date pubDt) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisherName = publisherName;
		this.price = price;
		this.pubDt = pubDt;
	}
	// Property accessors
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPubDt() {
		return pubDt;
	}

	public void setPubDt(Date pubDt) {
		this.pubDt = pubDt;
	}


	


	
}