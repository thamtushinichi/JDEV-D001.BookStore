package jvd001.bookstore.app.dao.usermanagement;

import jvd001.bookstore.app.dto.UserVO;

public interface UserLoginDAO {
	public UserVO checkLogin(String UsernameInput, String PasswordInput);
	
}
