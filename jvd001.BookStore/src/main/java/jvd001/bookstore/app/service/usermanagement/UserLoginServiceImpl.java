package jvd001.bookstore.app.service.usermanagement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jvd001.bookstore.app.dao.usermanagement.UserLoginDAO;
import jvd001.bookstore.app.dto.UserVO;
@Service("UserLoginService")
public class UserLoginServiceImpl implements UserLoginService {
	private UserLoginDAO UserLoginDAO;
	
	
	public UserLoginDAO getUserLoginDAO() {
		return UserLoginDAO;
	}


	public void setUserLoginDAO(UserLoginDAO userLoginDAO) {
		UserLoginDAO = userLoginDAO;
	}


	@Override
	public UserVO checkLogin(String UsernameInput, String PasswordInput) {
		// TODO Auto-generated method stub
		return UserLoginDAO.checkLogin(UsernameInput, PasswordInput);
	}
	
}
