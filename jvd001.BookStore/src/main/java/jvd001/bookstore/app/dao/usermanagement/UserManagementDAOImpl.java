package jvd001.bookstore.app.dao.usermanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jvd001.bookstore.app.model.usermanagement.User;

public class UserManagementDAOImpl implements UserManagementDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserManagementDAOImpl.class);
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<User> listBooks = session.createQuery("from user").list();
		for (User user : listBooks) {
			logger.info("User List::" + user);
		}
		return listUsers();
	}

	
	
	@Override
	public void addUser(User user) {
		Session session= this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details " +user);

	}

	

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user= (User)session.load(User.class, new Integer(id));
		if(null != user)
		{
			session.delete(user);
		}
		logger.info("User deleted successfully, Book Details =" + user);

	}

	@Override
	public User getidUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user= (User)session.load(User.class, new Integer(id));
		logger.info("user loaded successfully, user Details =" + user);
		return user;
		
	}

	@Override
	public void upadateUser(User user) {
		Session session= this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully, user Details =" + user);
		
	}

}
