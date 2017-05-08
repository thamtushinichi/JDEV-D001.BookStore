package jvd001.bookstore.app.dto;

public class BookSearchCondition {
	private String category_name;
	private String title;
	private String publisher;
	private String year_of_publishing; //nam xuat ban
	
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
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
