package jvd001.bookstore.app.service.usermanagement;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jvd001.bookstore.app.dao.usermanagement.UserManagementDAO;
import jvd001.bookstore.app.model.usermanagement.User;

public class UsermanagementServiceImpl implements UsermanagementService {
	private UserManagementDAO userManagementDAO;
	

	public UserManagementDAO getUserManagementDAO() {
		return userManagementDAO;
	}
	public void setUserManagementDAO(UserManagementDAO userManagementDAO) {
		this.userManagementDAO = userManagementDAO;
	}
	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return this.userManagementDAO.listUsers();
	}
   
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.userManagementDAO.addUser(user);
	}
    
    @Transactional
	@Override
	public void upadateUser(User user) {
		// TODO Auto-generated method stub
		this.userManagementDAO.upadateUser(user);
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		this.userManagementDAO.removeUser(id);
	}

	@Override
	public User getidUser(int id) {
		// TODO Auto-generated method stub
		return this.userManagementDAO.getidUser(id);
	}
	

}
