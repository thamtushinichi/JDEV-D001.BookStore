package jvd001.bookstore.app.dao.bookmanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import jvd001.bookstore.app.model.bookmanagement.Book;

public class BookManagementDAOImpl extends HibernateDaoSupport implements BookManagementDAO{

	private static final Logger logger=LoggerFactory.getLogger(BookManagementDAOImpl.class);

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		DetachedCriteria criteria= DetachedCriteria.forClass(Book.class);
		return (List<Book>)getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<Book> getBookById(int id) {
		// TODO Auto-generated method stub
		List results=getHibernateTemplate().find("from Book where book_id = ? ",new Object[]{id});
		
		return results.size() > 0 ? results : null;
	}

	@Override
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		
	}
	

	
}
