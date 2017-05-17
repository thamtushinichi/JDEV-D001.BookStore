package jvd001.bookstore.app.dao.bookmanagement;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.dto.UploadVO;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.dto.BookSearchCondition;

public interface BookManagementDAO {
	public Integer addBook(BookVO book);
	public void uploadFileBook(UploadVO upload);
	public void updateBook(BookVO book);
	public List<BookVO> listBooks();
	public List<BookVO> getBookById(int id);
	public void removeBook(int id);
	public List<BookVO> getListBookByPage(int pageStart,int NumberImageRender);
	public List<BookVO> getBooksStandard( int start, int record);
	public List<BookVO> getListBookByCategory(BookSearchCondition sc);
	public List<BookVO> getListBookByTitle(BookSearchCondition sc);
	public List<BookVO> getListBookByPublisher(BookSearchCondition sc);
	public List<BookVO> getListBookByYearOfPublishing(BookSearchCondition sc);
	public List<BookVO> getListBookBySearchCondition(BookSearchCondition sc);
	public int getMaxId();
	
} 
