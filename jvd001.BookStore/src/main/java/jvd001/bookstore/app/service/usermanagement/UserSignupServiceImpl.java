package jvd001.bookstore.app.service.usermanagement;

import org.springframework.stereotype.Service;

import jvd001.bookstore.app.dao.usermanagement.UserSignupDAO;
import jvd001.bookstore.app.dto.UserVO;

@Service("UserSignupService")
public class UserSignupServiceImpl implements UserSignupService {
	private UserSignupDAO UserSignupDAO;
	
	public UserSignupDAO getUserSignupDAO() {
		return UserSignupDAO;
	}
	
	public void setUserSignupDAO(UserSignupDAO userSignupDAO) {
		UserSignupDAO = userSignupDAO;
	}

	@Override
	public boolean ExecuteSignup(UserVO UserVO) {
		// TODO Auto-generated method stub
		return UserSignupDAO.ExecuteSignup(UserVO);
	}
	

	
}
