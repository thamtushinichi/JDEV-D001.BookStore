package jvd001.bookstore.app.dao.usermanagement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.model.usermanagement.User;

@Repository("UserLoginDAO")
@Transactional
public class UserLoginDAOImpl extends HibernateDaoSupport implements UserLoginDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserLoginDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public UserVO checkLogin(String UsernameInput, String PasswordInput) {
		UserVO UserVO= new UserVO();
		PasswordInput=cryptWithMD5(PasswordInput);
		List<User> results = (List<User>) getHibernateTemplate().find("from" + " User " + "where username = ? and password= ? ",
				new Object[] { UsernameInput,PasswordInput });
		if(results.size()>0){
			User u = results.get(0);
			UserVO.setUsers_id(u.getUsers_id());
			UserVO.setUsername(u.getUsername());
			UserVO.setFullname(u.getFullname());
			UserVO.setRole_id(u.getRole_id());
			return UserVO;
		}
		else{
		return null;
		}
	}
	public static String cryptWithMD5(String pass){
	    try {
	    	MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	       ex.printStackTrace();
	    }
	        return null;


	   }
}
