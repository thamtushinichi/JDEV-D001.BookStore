package jvd001.bookstore.app.model.classification;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import jvd001.bookstore.app.model.bookmanagement.Book;

@Entity
@Table(name = "category")
public class Category implements java.io.Serializable{

	/**
	 * Entity bean with JPA annotations Hibernate provides JPA implementation
	 * 
	 * @author ltphan91
	 *
	 */
	public Category()
	{
		
	}
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int category_id;

	private String category_name;
	private Set<Book> books= new HashSet<Book>();
	
	@ManyToMany(mappedBy = "BOOK")
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
}
