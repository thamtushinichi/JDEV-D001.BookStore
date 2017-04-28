package jvd001.bookstore.app.model.usermanagement;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jvd001.bookstore.app.model.bookmanagement.Book;





@Entity
@Table(name="users")
public class User implements java.io.Serializable{
	public User()
	{
		
	}
	@Id
	@Column(name="users_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int users_id;
	private String username;
	private String password;
	private String fullname;
	private int role_id;
	private String email;
	private int sex;
	private int address;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	@JoinColumn(name="book_id")
	private Set<Book> book = new HashSet<Book>(0);
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	@Override
	public String toString()
	{
		return "id: " + this.users_id+"username: "+ this.username+"full name la : "+this.fullname;
	}

}
