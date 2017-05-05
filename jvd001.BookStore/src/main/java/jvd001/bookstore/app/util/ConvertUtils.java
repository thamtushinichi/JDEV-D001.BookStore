/**
 * 
 */
package jvd001.bookstore.app.util;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.model.bookmanagement.Book;

/**
 * @author User
 *
 */
public class ConvertUtils {
	/**
	 * Convert BookVO to Book
	 * @param bookVo
	 * @return object Book
	 */
	public static Book convertBookVOToBook(BookVO bookVO) {
		Book book = new Book();
		// code here
		book.setAuthor(bookVO.getAuthor());
		book.setBook_Id(bookVO.getBook_Id());
		book.setDescription(bookVO.getDescription());
		book.setCategory_Id(bookVO.getCategory_Id());
		book.setImage(bookVO.getImage());
		book.setPublisher(bookVO.getPublisher());
		book.setTitle(bookVO.getTitle());
		book.setYear_Of_Publishing(bookVO.getYear_Of_Publishing());
		book.setUploads(bookVO.getUploads());
		book.setUser(bookVO.getUser());
		book.setCategories(bookVO.getCategories());
		
		return book;
	}
	
	/**
	 * Convert Book to BookVO
	 * @param book
	 * @return object BookVO
	 */
	public static BookVO convertBookToBookVO(Book book) {
		BookVO bookVO = new BookVO();
		// code here
		bookVO.setAuthor(book.getAuthor());
		bookVO.setBook_Id(book.getBook_Id());
		bookVO.setDescription(book.getDescription());
		bookVO.setCategory_Id(book.getCategory_Id());
		bookVO.setImage(book.getImage());
		bookVO.setPublisher(book.getPublisher());
		bookVO.setTitle(book.getTitle());
		bookVO.setYear_Of_Publishing(book.getYear_Of_Publishing());
		bookVO.setUploads(book.getUploads());
		bookVO.setUser(book.getUser());
		bookVO.setCategories(book.getCategories());
		return bookVO;
	}
}
