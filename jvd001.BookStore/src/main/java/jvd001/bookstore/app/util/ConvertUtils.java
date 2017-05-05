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
	public static Book convertBookVOToBook(BookVO bookVo) {
		Book book = new Book();
		// code here
		
		return book;
	}
	
	/**
	 * Convert Book to BookVO
	 * @param book
	 * @return object BookVO
	 */
	public static BookVO convertBookToBookVO(Book book) {
		BookVO bookVo = new BookVO();
		// code here
		
		return bookVo;
	}
}
