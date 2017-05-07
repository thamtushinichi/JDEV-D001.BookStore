package jvd001.bookstore.app.dao.bookmanagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
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

	public void addBook(BookVO book) {
		// TODO Auto-generated method stub
		
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
		List<Book> books= (List<Book>)getHibernateTemplate().findByCriteria(criteria);
		List<BookVO> bookVOs = new ArrayList<BookVO>();
		for(Book a:books)
		{
			bookVOs.add(ConvertUtils.convertBookToBookVO(a));
		}
		
		 return bookVOs;
	        
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

	@Override
	public List<BookVO> getListBookByPage(int pageStart,int NumberImageRender) {
		// TODO Auto-generated method stub
		List<BookVO> bookVOs= this.listBooks();
		List<BookVO> listBookByPage= new ArrayList<BookVO>();
		int startIndex=(pageStart-1)*NumberImageRender;
		int endIndex=pageStart*NumberImageRender;
		for(int i=startIndex;i<bookVOs.size() && i<endIndex;i++)
		{
			listBookByPage.add(bookVOs.get(i));
		}
		return listBookByPage;
	}
	public List<BookVO> getBooksStandard( int start, int record) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			List<Book> books = new ArrayList<Book>();
			String queryStr = "select book from Book book ";
			//queryStr += makeQueryString(queryConditions, logicOperator);
			
			Query query = session.createQuery(queryStr);
			query.setFirstResult(start);
			query.setMaxResults(record);
			
			for (Iterator iterator = query.iterate() ; iterator.hasNext();) {
				books.add((Book)iterator.next());
			}
			
			List<BookVO> bookVos = new ArrayList<BookVO>();
			for (Book book : books) {
				bookVos.add(ConvertUtils.convertBookToBookVO(book));
			}
			return bookVos;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	
}
