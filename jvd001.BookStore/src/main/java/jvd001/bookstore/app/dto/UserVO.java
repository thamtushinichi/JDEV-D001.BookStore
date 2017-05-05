package jvd001.bookstore.app.dto;

import java.util.HashSet;
import java.util.Set;

import jvd001.bookstore.app.model.bookmanagement.Book;

public class UserVO {

	private int users_id;

	private String username;

	private String password;

	private String fullname;

	private int role_id;

	private String email;

	private int sex;

	private String address;

	private Set<Book> listBook = new HashSet<Book>(0);

	public Set<Book> getListBook() {
		return listBook;
	}

	public void setListBook(Set<Book> listBook) {
		this.listBook = listBook;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "id: " + this.users_id + "username: " + this.username + "full name la : " + this.fullname;
	}

}