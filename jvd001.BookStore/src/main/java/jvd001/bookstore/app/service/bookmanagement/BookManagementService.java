package jvd001.bookstore.app.service.bookmanagement;

import java.util.List;

import jvd001.bookstore.app.dto.BookVO;

public interface BookManagementService {
	public void addBook(BookVO book);
	public void updateBook(BookVO book);
	public List<BookVO> listBooks();
	public List<BookVO> getBookById(int id);
	public void removeBook(int id);
	public List<BookVO> getListBookByPage(int pageStart,int NumberImageRender);
	public List<BookVO> getBooksStandard( int pageStart, int record);
}
