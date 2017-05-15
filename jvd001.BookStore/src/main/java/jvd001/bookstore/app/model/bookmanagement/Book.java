package jvd001.bookstore.app.model.bookmanagement;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.model.usermanagement.User;

@Entity
@Table(name = "book")
public class Book implements java.io.Serializable {
	public Book() {

	}

	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_Id;
	@Column(name = "title")
	private String title;
	//private int user_Id;
	@Column(name = "category_id")
	private int category_Id;
	@Column(name = "publisher")
	private String publisher;
	@Column(name = "year_of_publishing")
	private String year_Of_Publishing;
	@Column(name = "author")
	private String author;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String image;
	@ManyToMany(cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
	@JoinTable(name = "book_category", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	private Set<Category> categories = new HashSet<Category>(0);

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "users_id", nullable = false)
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "book")
	private Set<Upload> uploads = new HashSet<Upload>(0);

	public Set<Upload> getUploads() {
		return uploads;
	}

	public void setUploads(Set<Upload> uploads) {
		this.uploads = uploads;
	}

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
	
	

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	@Override
	public String toString()
	{
		return "title: "+ this.title+" " + " "+ this.book_Id + "user fullname la : " + this.user.getFullname();
	}
}
