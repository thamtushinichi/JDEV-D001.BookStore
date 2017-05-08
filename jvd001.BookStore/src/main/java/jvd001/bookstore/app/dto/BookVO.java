package jvd001.bookstore.app.dto;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import jvd001.bookstore.app.model.bookmanagement.Upload;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.model.usermanagement.User;

public class BookVO {
	private int book_Id;
	private String title;
	private int user_Id;
	private int category_Id;
	private String publisher;
	private String year_Of_Publishing;
	private String author;
	private String description;
	private String image;
	private User user;
	private MultipartFile file;
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Upload> getUploads() {
		return uploads;
	}
	public void setUploads(Set<Upload> uploads) {
		this.uploads = uploads;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	private Set<Upload> uploads;
	private Set<Category> categories;
	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public int getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYear_Of_Publishing() {
		return year_Of_Publishing;
	}
	public void setYear_Of_Publishing(String year_Of_Publishing) {
		this.year_Of_Publishing = year_Of_Publishing;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
