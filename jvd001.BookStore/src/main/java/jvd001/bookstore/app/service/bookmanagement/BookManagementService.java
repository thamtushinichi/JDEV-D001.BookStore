package jvd001.bookstore.app.service.bookmanagement;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.dto.BookSearchCondition;

public interface BookManagementService {
	public Integer addBook(BookVO book);
	public void updateBook(BookVO book);
	public List<BookVO> listBooks();
	public List<BookVO> getBookById(int id);
	public void removeBook(int id);
	public List<BookVO> getListBookByPage(int pageStart,int NumberImageRender);
	public List<BookVO> getBooksStandard( int pageStart, int record);
	public List<BookVO> getListBookByCategory(BookSearchCondition sc);
	public List<BookVO> getListBookByTitle(BookSearchCondition sc);
	public List<BookVO> getListBookByPublisher(BookSearchCondition sc);
	public List<BookVO> getListBookByYearOfPublishing(BookSearchCondition sc);
	public List<BookVO> getListBookBySearchCondition(BookSearchCondition sc);
	public int getMaxId();
	public List<BookVO> getListBook_By_SearchCondition_Per_Page(BookSearchCondition sc,int start_Page,int nRecord_Per_Page);
	public long getSize_By_SearchCondition_Per_Page(BookSearchCondition sc);
}
