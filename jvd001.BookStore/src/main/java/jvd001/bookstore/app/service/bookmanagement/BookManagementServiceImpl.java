package jvd001.bookstore.app.service.bookmanagement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jvd001.bookstore.app.dao.bookmanagement.BookManagementDAO;
import jvd001.bookstore.app.dto.BookVO;

@Service
@Transactional(value="LiveTransactionManager") 
public class BookManagementServiceImpl implements BookManagementService{
	private BookManagementDAO bookManagementDAO;
	public BookManagementDAO getBookManagementDAO() {
		return bookManagementDAO;
	}

	public void setBookManagementDAO(BookManagementDAO bookManagementDAO) {
		this.bookManagementDAO = bookManagementDAO;
	}

	@Override
	@Transactional
	public void addBook(BookVO book) {
		// TODO Auto-generated method stub
		this.bookManagementDAO.addBook(book);
	}

	@Override
	@Transactional
	public void updateBook(BookVO book) {
		// TODO Auto-generated method stub
		this.bookManagementDAO.updateBook(book);
	}

	@Override
	@Transactional
	public List<BookVO> listBooks() {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.listBooks();
	}

	@Override
	@Transactional
	public List<BookVO> getBookById(int id) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getBookById(id);
	}

	@Override
	@Transactional
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		this.bookManagementDAO.removeBook(id);
	}

}
