package jvd001.bookstore.app.util;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.model.bookmanagement.Book;
import jvd001.bookstore.app.model.usermanagement.*;

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
//		book.setCategory_Ids(bookVO.getCategory_Ids());
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
//		bookVO.setCategory_Ids(book.getCategory_Ids());
		bookVO.setImage(book.getImage());
		bookVO.setPublisher(book.getPublisher());
		bookVO.setTitle(book.getTitle());
		bookVO.setYear_Of_Publishing(book.getYear_Of_Publishing());
		bookVO.setUploads(book.getUploads());
		bookVO.setUser(book.getUser());
		bookVO.setCategories(book.getCategories());
		return bookVO;
	}
	/**
	 * Convert UserVOToUse
	 * @param UserVO
	 * @return object Use
	 */
	public static User convertUserVOToUser(UserVO userVO){
		User user = new User();
		user.setUsers_id(userVO.getUsers_id());
		user.setAddress(userVO.getAddress());
		user.setEmail(userVO.getEmail());
		user.setPassword(userVO.getPassword());
		user.setFullname(userVO.getFullname());
		user.setSex(userVO.getSex());
		user.setUsername(userVO.getUsername());
		user.setRole_id(userVO.getRole_id());
		return user;
				
	}
	
	/**
	 * Convert UserToUseVO
	 * @param User
	 * @return object UseVO
	 */
	public static UserVO convertUserToUserVO(User user){
		UserVO userVO = new UserVO();
        userVO.setUsers_id(user.getUsers_id());
		userVO.setAddress(user.getAddress());
		userVO.setEmail(user.getEmail());
		userVO.setPassword(user.getPassword());
		userVO.setFullname(user.getFullname());
		userVO.setSex(user.getSex());
		userVO.setUsername(user.getUsername());
		userVO.setRole_id(user.getRole_id());
		return userVO;
		
	}
	

}
