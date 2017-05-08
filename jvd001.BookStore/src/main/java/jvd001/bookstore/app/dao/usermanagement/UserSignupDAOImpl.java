package jvd001.bookstore.app.dao.usermanagement;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.model.usermanagement.User;
import jvd001.bookstore.app.util.ConvertUtils;

public class UserSignupDAOImpl extends HibernateDaoSupport implements UserSignupDAO {

	@Override
	public UserVO ExecuteSignup(UserVO UserVO) {
		// TODO Auto-generated method stub
		UserVO.setRole_id(1);
		User User = new User();
		ConvertUtils c = new ConvertUtils();
		User=c.convertUserVOToUser(UserVO);
		getHibernateTemplate().save(User);
		return UserVO;
	}

	

}