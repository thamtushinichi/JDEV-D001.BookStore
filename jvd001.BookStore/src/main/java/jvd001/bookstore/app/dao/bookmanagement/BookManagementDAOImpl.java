package jvd001.bookstore.app.dao.bookmanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jvd001.bookstore.app.model.bookmanagement.Book;

public class BookManagementDAOImpl implements BookManagementDAO{

	private static final Logger logger=LoggerFactory.getLogger(BookManagementDAOImpl.class);
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Session session= this.sessionFactory.getCurrentSession();
		session.persist(book);
		logger.info("Book saved successfully, Book Details =" + book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		Session session= this.sessionFactory.getCurrentSession();
		session.update(book);
		logger.info("Book updated successfully, Book Details =" + book);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Book> listBooks= session.createQuery("from Book").list();
		for(Book book : listBooks){
			logger.info("Person List::"+book);
		}
		return listBooks;
		
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Book book= (Book)session.load(Book.class, new Integer(id));
		logger.info("Book loaded successfully, Book Details =" + book);
		return book;
	}

	@Override
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Book book= (Book)session.load(Book.class, new Integer(id));
		if(null != book)
		{
			session.delete(book);
		}
		logger.info("Book deleted successfully, Book Details =" + book);
	}
	
}
