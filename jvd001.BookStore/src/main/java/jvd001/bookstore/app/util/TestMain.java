package jvd001.bookstore.app.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jvd001.bookstore.app.model.bookmanagement.Book;
import jvd001.bookstore.app.model.usermanagement.User;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;
import jvd001.bookstore.app.service.usermanagement.UsermanagementService;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("************** BEGINNING PROGRAM **************");
		 
		ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
		System.out.println("************** ENDING PROGRAM **************");
	//	StudentManagementService studentService= (StudentManagementService) context.getBean("duke");
//		BookManagementService temp= (BookManagementService) context.getBean("bookmanagementService");
//		List<Book> a=temp.listBooks();
//		for(Book b:a)
//		{
//			b.toString();
//		}
		BookManagementService temp= (BookManagementService) context.getBean("bookmanagementService");
	List<Book> a=temp.listBooks();
	for(Book b:a)
		{
			System.out.println(b.toString());
		}
	}

}
