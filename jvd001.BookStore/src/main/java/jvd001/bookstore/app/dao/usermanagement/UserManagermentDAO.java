package jvd001.bookstore.app.dao.usermanagement;
import java.util.List;

import jvd001.bookstore.app.model.usermanagement.*;

public interface UserManagermentDAO {
	public List<User> listUsers();
	public void addUser (User user);
	public void upadateUser(User user);
	public void removeUser(int id);
	public User getidUser(int id);

}
