package jvd001.bookstore.app.dao.usermanagement;

import jvd001.bookstore.app.dto.UserVO;

public interface UserLoginDAO {
	public boolean checkLogin(String UsernameInput, String PasswordInput);
	
}
