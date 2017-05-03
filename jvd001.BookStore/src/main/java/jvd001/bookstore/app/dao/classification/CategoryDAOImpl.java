package jvd001.bookstore.app.dao.classification;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import jvd001.bookstore.app.model.classification.Category;

public class CategoryDAOImpl implements CategoryDAO {
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCategory(Category p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Category saved successfully, Person Details="+p);
	}

	@Override
	public void updateCategory(Category p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Category updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategory() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Category").list();
		for(Category p : categoryList){
			logger.info("Category List::"+p);
		}
		return categoryList;
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Category p = (Category) session.load(Category.class, new Integer(id));
		logger.info("Category loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category p = (Category) session.load(Category.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Category deleted successfully, person details="+p);
	}

}
