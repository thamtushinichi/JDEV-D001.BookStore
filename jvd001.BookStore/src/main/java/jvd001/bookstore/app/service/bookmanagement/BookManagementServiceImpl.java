package jvd001.bookstore.app.service.bookmanagement;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jvd001.bookstore.app.dao.bookmanagement.BookManagementDAO;
import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.dto.BookSearchCondition;

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
	public Integer addBook(BookVO book) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.addBook(book);
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

	@Override
	@Transactional
	public List<BookVO> getListBookByPage(int pageStart,int NumberImageRender) {
		// TODO Auto-generated method stub
		
		return this.bookManagementDAO.getListBookByPage(pageStart, NumberImageRender);
	}
	@Override
	@Transactional
	public List<BookVO> getBooksStandard( int pageStart, int record)
	{
		int start=(pageStart-1)*record;
		
		return this.bookManagementDAO.getBooksStandard(start, record);
	}

	@Override
	@Transactional
	public List<BookVO> getListBookByCategory(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getListBookByCategory(sc);
	}

	@Override
	@Transactional
	public List<BookVO> getListBookByTitle(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getListBookByTitle(sc);
	}

	@Override
	@Transactional
	public List<BookVO> getListBookByPublisher(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getListBookByPublisher(sc);
	}

	@Override
	@Transactional
	public List<BookVO> getListBookByYearOfPublishing(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getListBookByYearOfPublishing(sc);
	}

	@Override
	@Transactional
	public List<BookVO> getListBookBySearchCondition(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getListBookBySearchCondition(sc);
	}

	@Override
	@Transactional
	public int getMaxId() {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getMaxId();
	}

	@Override
	@Transactional
	public List<BookVO> getListBook_By_SearchCondition_Per_Page(BookSearchCondition sc, int start_Page,
			int nRecord_Per_Page) {
		int start=(start_Page-1)*nRecord_Per_Page;
		return this.bookManagementDAO.getListBook_By_SearchCondition_Per_Page(sc,start, nRecord_Per_Page);
	}

	@Override
	@Transactional
	public long getSize_By_SearchCondition_Per_Page(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		return this.bookManagementDAO.getSize_By_SearchCondition_Per_Page(sc);
	}

	@Override
	@Transactional
	public String getNameFile(String idbook) {
		return this.bookManagementDAO.getNameFile(idbook);
	}



}
