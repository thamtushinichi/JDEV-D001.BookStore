package jvd001.bookstore.app.dao.usermanagement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.model.usermanagement.User;
import jvd001.bookstore.app.util.ConvertUtils;

@Repository("UserSignupDAO")
@Transactional
public class UserSignupDAOImpl extends HibernateDaoSupport implements UserSignupDAO {

	@Override
	@Transactional(readOnly = false)
	public boolean ExecuteSignup(UserVO UserVO) {
		// TODO Auto-generated method stub

		UserVO.setRole_id(3);
		UserVO.setPassword(cryptWithMD5(UserVO.getPassword()));
		User User = new User();
		ConvertUtils c = new ConvertUtils();
		User = c.convertUserVOToUser(UserVO);
		if (!checkExistUser(User)) {
			getHibernateTemplate().save(User);
			return true;
		}

		return false;
	}

	public static String cryptWithMD5(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean checkExistUser(User User) {
		List<User> results = (List<User>) getHibernateTemplate().find(
				"from" + " User " + "where username = ? or email= ? ",
				new Object[] { User.getUsername(), User.getEmail() });
		if (results.isEmpty()) {
			return false;
		}
		return true;
	}

}