package jvd001.bookstore.app.service.usermanagement;

import jvd001.bookstore.app.dto.UserVO;

public interface UserLoginService {
	public boolean checkLogin(String UsernameInput, String PasswordInput);
}
