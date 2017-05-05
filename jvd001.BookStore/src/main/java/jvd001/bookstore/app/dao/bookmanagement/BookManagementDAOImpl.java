package jvd001.bookstore.app.dao.bookmanagement;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.model.bookmanagement.Book;
import jvd001.bookstore.app.util.ConvertUtils;
@Transactional
public class BookManagementDAOImpl extends HibernateDaoSupport implements BookManagementDAO{

	private static final Logger logger=LoggerFactory.getLogger(BookManagementDAOImpl.class);
	private ConvertUtils convertUtils;
	@SuppressWarnings("static-access")
	public void addBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		Book book = new Book();
		book = convertUtils.convertBookVOToBook(bookVO);
		getHibernateTemplate().save(book);
	}

	@Override
	public void updateBook(BookVO book) {
		// TODO Auto-generated method stub
		// convert
		
		// execure
		
	}

	@Override
	public List<BookVO> listBooks() {
		// TODO Auto-generated method stub
		
		 DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		List<BookVO> a= (List<BookVO>)getHibernateTemplate().findByCriteria(criteria);
		 return a;
	        
	}

	@Override
	public List<BookVO> getBookById(int id) {
		// TODO Auto-generated method stub
		List results=getHibernateTemplate().find("from Book where book_id = ? ",new Object[]{id});
		
		return results.size() > 0 ? results : null;
	}

	@Override
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		
	}
	

	
}
