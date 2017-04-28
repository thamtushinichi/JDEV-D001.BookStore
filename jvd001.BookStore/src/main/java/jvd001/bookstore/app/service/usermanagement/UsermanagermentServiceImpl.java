package jvd001.bookstore.app.service.usermanagement;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jvd001.bookstore.app.dao.usermanagement.UserManagermentDAO;
import jvd001.bookstore.app.model.usermanagement.User;

public class UsermanagermentServiceImpl implements UsermanagermentService {
	private UserManagermentDAO userManagermentDAO;
	

	public UserManagermentDAO getUserManagermentDAO() {
		return userManagermentDAO;
	}

	public void setUserManagermentDAO(UserManagermentDAO userManagermentDAO) {
		this.userManagermentDAO = userManagermentDAO;
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return this.userManagermentDAO.listUsers();
	}
    @Transactional
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.userManagermentDAO.addUser(user);
	}
    
    @Transactional
	@Override
	public void upadateUser(User user) {
		// TODO Auto-generated method stub
		this.userManagermentDAO.upadateUser(user);
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		this.userManagermentDAO.removeUser(id);
	}

	@Override
	public User getidUser(int id) {
		// TODO Auto-generated method stub
		return this.userManagermentDAO.getidUser(id);
	}
	

}
