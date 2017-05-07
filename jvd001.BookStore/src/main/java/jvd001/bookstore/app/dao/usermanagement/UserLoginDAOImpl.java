package jvd001.bookstore.app.dao.usermanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.model.usermanagement.User;


public class UserLoginDAOImpl implements UserLoginDAO{
	private static final Logger logger = LoggerFactory.getLogger(UserLoginDAOImpl.class);


	
	@Override
	public UserVO checkPassword(String UsernameInput, String PasswordInput) {
		// TODO Auto-generated method stub
		UserVO UserVO = null;
		return UserVO;
	}

}
