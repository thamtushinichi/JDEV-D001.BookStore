package jvd001.bookstore.app.service.usermanagement;

import java.util.List;

import jvd001.bookstore.app.model.usermanagement.User;

public interface UsermanagermentService {
	public List<User> listUsers();
	public void addUser (User user);
	public void upadateUser(User user);
	public void removeUser(int id);
	public User getidUser(int id);
}
