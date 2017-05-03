package jvd001.bookstore.app.service.bookmanagement;

import java.util.List;



import jvd001.bookstore.app.dao.bookmanagement.BookManagementDAO;
import jvd001.bookstore.app.model.bookmanagement.Book;

public class BookManagementServiceImpl implements BookManagementService{
	private BookManagementDAO bookManagementDAO;
	public BookManagementDAO getBookManagementDAO() {
		return bookManagementDAO;
	}

	public void setBookManagementDAO(BookManagementDAO bookManagementDAO) {
		this.bookManagementDAO = bookManagementDAO;
	}

	@Override
	
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		this.bookManagementDAO.addBook(book);
	}

	@Override
	
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		this.bookManagementDAO.updateBook(book);
	}

	@Override
	
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.listBooks();
	}

	@Override
	
	public List<Book> getBookById(int id) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getBookById(id);
	}

	@Override
	
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		this.bookManagementDAO.removeBook(id);
	}

}
