package jvd001.bookstore.app.service.bookmanagement;

import java.util.List;

import jvd001.bookstore.app.model.bookmanagement.Book;

public interface BookManagementService {
	public void addBook(Book book);
	public void updateBook(Book book);
	public List<Book> listBooks();
	public Book getBookById(int id);
	public void removeBook(int id);
}
