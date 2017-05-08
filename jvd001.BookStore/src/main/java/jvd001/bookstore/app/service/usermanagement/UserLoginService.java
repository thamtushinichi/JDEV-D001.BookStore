package jvd001.bookstore.app.service.usermanagement;

import jvd001.bookstore.app.dto.UserVO;

public interface UserLoginService {
	public UserVO checkLogin(String UsernameInput, String PasswordInput);
}
