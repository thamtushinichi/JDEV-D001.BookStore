/*
 * ClassName: BookManagementDAO
 * Version information: 1.0
 * Date: 10/6/2017
 * Copyright
 */
package jvd001.bookstore.app.dao.bookmanagement;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.dto.UploadVO;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.dto.BookSearchCondition;

public interface BookManagementDAO {
	/*
	 * this class is interface this class is using to communication with
	 * Database this class used Hibernate Template to communicate
	 */
	// delete a book with book id
	public void deleteBook(int book_Id);

	// add a book with book information
	public Integer addBook(BookVO book);

	// upload a book file
	public void uploadFileBook(UploadVO upload);

	// update a book
	public void updateBook(BookVO book);

	// get listbook
	public List<BookVO> listBooks();

	// get a book by book id
	public List<BookVO> getBookById(int id);

	// remove a book with book id
	public void removeBook(int id);

	// get listbook by page with page start and max number in one page
	public List<BookVO> getListBookByPage(int pageStart, int NumberImageRender);

	// get list book in a page
	public List<BookVO> getBooksStandard(int start, int record);

	// get list book by category
	public List<BookVO> getListBookByCategory(BookSearchCondition sc);

	// get list book by title
	public List<BookVO> getListBookByTitle(BookSearchCondition sc);

	// get list book by publisher
	public List<BookVO> getListBookByPublisher(BookSearchCondition sc);

	// get list book by year of publishing
	public List<BookVO> getListBookByYearOfPublishing(BookSearchCondition sc);

	// get list book by search condition which includes
	// category id, title, publisher and year of publishing
	public List<BookVO> getListBookBySearchCondition(BookSearchCondition sc);

	// get max id in database
	public int getMaxId();

	// get size of list book
	public int getSizeListBook();

	// get list book in a page by search condition which includes
	// category id, title, publisher and year of publishing
	public List<BookVO> getListBook_By_SearchCondition_Per_Page(BookSearchCondition sc, int start_Page,
			int nRecord_Per_Page);

	// get size when we search book in a page
	public long getSize_By_SearchCondition_Per_Page(BookSearchCondition sc);

	// get file name of a book
	public String getNameFile(String idbook);
}
