/*
 * ClassName: BookSearchCondition
 * Version information: 1.0
 * Date: 10/6/2017
 * Copyright notice
 */
package jvd001.bookstore.app.dto;

public class BookSearchCondition {
	/*
	 * Using for Search Book from Web 
	 * 
	 */
	private int category_id;
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	private String title;
	private String publisher;
	private String year_of_publishing; //nam xuat ban
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYear_of_publishing() {
		return year_of_publishing;
	}
	public void setYear_of_publishing(String year_of_publishing) {
		this.year_of_publishing = year_of_publishing;
	}
}
