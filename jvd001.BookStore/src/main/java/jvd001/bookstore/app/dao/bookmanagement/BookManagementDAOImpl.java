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
import org.springframework.util.StringUtils;

import jvd001.bookstore.app.dto.BookSearchCondition;
import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.dto.UploadVO;
import jvd001.bookstore.app.model.bookmanagement.Book;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.util.ConvertUtils;

@Transactional
public class BookManagementDAOImpl extends HibernateDaoSupport implements BookManagementDAO {

	private static final Logger logger = LoggerFactory.getLogger(BookManagementDAOImpl.class);
	private ConvertUtils convertUtils;

	@SuppressWarnings("static-access")
	public Integer addBook(BookVO bookVO) {
		// TODO Auto-generated method stub

		Book book = new Book();
		book = convertUtils.convertBookVOToBook(bookVO);
		return (Integer) getHibernateTemplate().save(book);
	}

	@Override
	public void deleteBook(int book_Id) {
		// TODO Auto-generated method stub
		Book book = (Book) getHibernateTemplate().load(Book.class, new Integer(book_Id));
		getHibernateTemplate().delete(book);
	}

	@SuppressWarnings("static-access")
	@Override
	public void updateBook(BookVO bookVO) {
		// TODO Auto-generated method stub
		Book book = new Book();
		// convert
		book = convertUtils.convertBookVOToBook(bookVO);
		getHibernateTemplate().update(book);
		// execure

	}

	@Override
	public List<BookVO> listBooks() {
		// TODO Auto-generated method stub

		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		List<Book> books = (List<Book>) getHibernateTemplate().findByCriteria(criteria);
		List<BookVO> bookVOs = new ArrayList<BookVO>();
		for (Book a : books) {
			bookVOs.add(ConvertUtils.convertBookToBookVO(a));
		}

		return bookVOs;

	}

	@Override
	public List<BookVO> getBookById(int id) {
		// TODO Auto-generated method stub

		List results=getHibernateTemplate().find("select book from Book book where book.book_Id = "+id);
		List<BookVO> listBookVO = new ArrayList<BookVO>();
		for(int i=0;i<results.size();i++)
		{
			listBookVO.add(ConvertUtils.convertBookToBookVO((Book)results.get(i)));
		}
		return results.size() > 0 ? listBookVO : null;
	}

	@Override
	public void removeBook(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BookVO> getListBookByPage(int pageStart, int NumberImageRender) {
		// TODO Auto-generated method stub
		List<BookVO> bookVOs = this.listBooks();
		List<BookVO> listBookByPage = new ArrayList<BookVO>();
		int startIndex = (pageStart - 1) * NumberImageRender;
		int endIndex = pageStart * NumberImageRender;
		for (int i = startIndex; i < bookVOs.size() && i < endIndex; i++) {
			listBookByPage.add(bookVOs.get(i));
		}
		return listBookByPage;
	}

	public List<BookVO> getBooksStandard(int start, int record) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			List<Book> books = new ArrayList<Book>();
			String queryStr = "select book from Book book ";
//			 queryStr += makeQueryString(queryConditions, logicOperator);

			Query query = session.createQuery(queryStr);
			query.setFirstResult(start);
			query.setMaxResults(record);

			for (Iterator iterator = query.iterate(); iterator.hasNext();) {
				books.add((Book) iterator.next());
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

	@Override
	public List<BookVO> getListBookByCategory(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		// List<BookVO> listBookVO= this.listBooks();
		// Set<Category> categories;
		// List<BookVO> results =new ArrayList<BookVO>();
		// if(listBookVO.size()==0)
		// {
		// return null;
		// }
		//
		// else
		// {
		// for(int i=0;i<listBookVO.size();i++)
		// {
		// List<Category> listCategory=new
		// ArrayList<Category>(listBookVO.get(i).getCategories());
		// for(int j=0;j<listCategory.size();j++)
		// {
		// // so sanh ten category de lay duoc cuon sach co category do
		// if(listCategory.get(j).getCategory_name().equals(sc.getCategory_name()))
		// {
		// results.add(listBookVO.get(i));
		// break;
		// }
		// }
		// }
		// }
		// return results.size() > 0 ? results : null;
		return null;
	}

	@Override
	public List<BookVO> getListBookByTitle(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		List results = getHibernateTemplate().find("select book from Book book where book.title=?",
				new Object[] { sc.getTitle() });
		List<BookVO> listBookVO = new ArrayList<BookVO>();
		for (int i = 0; i < results.size(); i++) {

			listBookVO.add(ConvertUtils.convertBookToBookVO((Book) results.get(i)));
		}
		return results.size() > 0 ? listBookVO : null;
	}

	@Override
	public List<BookVO> getListBookByPublisher(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		List results = getHibernateTemplate().find("select book from Book book where book.publisher= ? ",
				new Object[] { sc.getPublisher() });
		List<BookVO> listBookVO = new ArrayList<BookVO>();
		for (int i = 0; i < results.size(); i++) {

			listBookVO.add(ConvertUtils.convertBookToBookVO((Book) results.get(i)));
		}
		return results.size() > 0 ? listBookVO : null;
	}

	@Override
	public List<BookVO> getListBookByYearOfPublishing(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		List results = getHibernateTemplate().find("select book from Book book where book.year_of_publishing= ? ",
				new Object[] { sc.getYear_of_publishing() });

		List<BookVO> listBookVO = new ArrayList<BookVO>();
		for (int i = 0; i < results.size(); i++) {

			listBookVO.add(ConvertUtils.convertBookToBookVO((Book) results.get(i)));
		}
		return results.size() > 0 ? listBookVO : null;
	}

	@Override
	public List<BookVO> getListBookBySearchCondition(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		String query="select book from Category cat join cat.books book where 1=1";
		if(sc.getCategory_id()!=0)
		{
			query="select book from Category cat join cat.books book where 1=1";
			String q1= " and cat.category_id = "+sc.getCategory_id() ;
			query=query +q1;
			if(!StringUtils.isEmpty(sc.getTitle()))
			{
				String q2= " and book.title = " +"\'"+ sc.getTitle()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getPublisher()))
			{
				String q2= " and book.publisher = " +"\'" +sc.getPublisher()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getYear_of_publishing()))
			{
				String q2= " and book.year_Of_Publishing = " +"\'"+ sc.getYear_of_publishing()+"\'";
				query=query +q2;
			}
		}
		else
		{
			query="select book from Book book where 1=1";
			if(!StringUtils.isEmpty(sc.getTitle()))
			{
				String q2= " and book.title = " +"\'"+ sc.getTitle()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getPublisher()))
			{
				String q2= " and book.publisher = " +"\'" +sc.getPublisher()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getYear_of_publishing()))
			{
				String q2= " and book.year_Of_Publishing = " +"\'"+ sc.getYear_of_publishing()+"\'";
				query=query +q2;
			}
		}
		System.out.println("query: "+query);
		List results=getHibernateTemplate().find(query);
		List<BookVO> listBookVO = new ArrayList<BookVO>();
		for(int i=0;i<results.size();i++)
		{
			listBookVO.add(ConvertUtils.convertBookToBookVO((Book)results.get(i)));
		}
		return results.size() > 0 ? listBookVO : null;
		
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		
		int maxId=0;
		List<Integer> results= (List<Integer>) getHibernateTemplate().find("select max(book.book_Id) from Book book");
	
		if(results.size()>0)
		{
			maxId = results.get(0);
			System.out.print("chay toi day id la: " + maxId);
			return maxId;
		}
		 return -1;
		
	}

	@Override
	public void uploadFileBook(UploadVO upload) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSizeListBook() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> getListBook_By_SearchCondition_Per_Page(BookSearchCondition sc, int start_Page,
			int nRecord_Per_Page) {
		// TODO Auto-generated method stub
		String query="select book from Category cat join cat.books book where 1=1";
		if(sc.getCategory_id()!=0)
		{
			query="select book from Category cat join cat.books book where 1=1";
			String q1= " and cat.category_id = "+sc.getCategory_id() ;
			query=query +q1;
			if(!StringUtils.isEmpty(sc.getTitle()))
			{
				String q2= " and book.title = " +"\'"+ sc.getTitle()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getPublisher()))
			{
				String q2= " and book.publisher = " +"\'" +sc.getPublisher()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getYear_of_publishing()))
			{
				String q2= " and book.year_Of_Publishing = " +"\'"+ sc.getYear_of_publishing()+"\'";
				query=query +q2;
			}
		}
		else
		{
			query="select book from Book book where 1=1";
			if(!StringUtils.isEmpty(sc.getTitle()))
			{
				String q2= " and book.title = " +"\'"+ sc.getTitle()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getPublisher()))
			{
				String q2= " and book.publisher = " +"\'" +sc.getPublisher()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getYear_of_publishing()))
			{
				String q2= " and book.year_Of_Publishing = " +"\'"+ sc.getYear_of_publishing()+"\'";
				query=query +q2;
			}
		}
		System.out.println("query: "+query);
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			List<Book> books = new ArrayList<Book>();
			
//			 queryStr += makeQueryString(queryConditions, logicOperator);

			Query queryQ = session.createQuery(query);
			queryQ.setFirstResult(start_Page);
			queryQ.setMaxResults(nRecord_Per_Page);

			for (Iterator iterator = queryQ.iterate(); iterator.hasNext();) {
				books.add((Book) iterator.next());
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

	@Override
	public long getSize_By_SearchCondition_Per_Page(BookSearchCondition sc) {
		// TODO Auto-generated method stub
		String query="select count(*) from Category cat join cat.books book where 1=1";
		if(sc.getCategory_id()!=0)
		{
			query="select count(*) from Category cat join cat.books book where 1=1";
			String q1= " and cat.category_id = "+sc.getCategory_id() ;
			query=query +q1;
			if(!StringUtils.isEmpty(sc.getTitle()))
			{
				String q2= " and book.title = " +"\'"+ sc.getTitle()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getPublisher()))
			{
				String q2= " and book.publisher = " +"\'" +sc.getPublisher()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getYear_of_publishing()))
			{
				String q2= " and book.year_Of_Publishing = " +"\'"+ sc.getYear_of_publishing()+"\'";
				query=query +q2;
			}
		}
		else
		{
			query="select count(*) from Book book where 1=1";
			if(!StringUtils.isEmpty(sc.getTitle()))
			{
				String q2= " and book.title = " +"\'"+ sc.getTitle()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getPublisher()))
			{
				String q2= " and book.publisher = " +"\'" +sc.getPublisher()+"\'";
				query=query +q2;
			}
			if(!StringUtils.isEmpty(sc.getYear_of_publishing()))
			{
				String q2= " and book.year_Of_Publishing = " +"\'"+ sc.getYear_of_publishing()+"\'";
				query=query +q2;
			}
		}
		System.out.println("query: "+query);
		List<Long> results=(List<Long>) getHibernateTemplate().find(query);
		long nRecord=0;
		if(results.size()>0)
		{
			nRecord = results.get(0);
			System.out.print("Record Sum is: " + nRecord);
			return nRecord;
		}
		 return -1;
		
	}


}
