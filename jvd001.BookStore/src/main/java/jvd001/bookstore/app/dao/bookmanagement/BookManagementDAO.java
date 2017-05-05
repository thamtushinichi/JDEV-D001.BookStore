package jvd001.bookstore.app.dao.bookmanagement;

import java.util.List;

import jvd001.bookstore.app.dto.BookVO;

public interface BookManagementDAO {
	public void addBook(BookVO book);
	public void updateBook(BookVO book);
	public List<BookVO> listBooks();
	public List<BookVO> getBookById(int id);
	public void removeBook(int id);
}
