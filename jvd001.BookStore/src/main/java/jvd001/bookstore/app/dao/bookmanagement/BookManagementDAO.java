package jvd001.bookstore.app.dao.bookmanagement;

import java.util.List;

import jvd001.bookstore.app.model.bookmanagement.Book;

public interface BookManagementDAO {
	public void addBook(Book book);
	public void updateBook(Book book);
	public List<Book> listBooks();
	public List<Book> getBookById(int id);
	public void removeBook(int id);
}
