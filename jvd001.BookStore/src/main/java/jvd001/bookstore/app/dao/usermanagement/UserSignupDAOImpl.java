package jvd001.bookstore.app.dao.usermanagement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	@Transactional(readOnly=false)
	public UserVO ExecuteSignup(UserVO UserVO) {
		// TODO Auto-generated method stub
		
		UserVO.setRole_id(1);
		UserVO.setPassword(cryptWithMD5(UserVO.getPassword()));
		User User = new User();
		ConvertUtils c = new ConvertUtils();
		User=c.convertUserVOToUser(UserVO);
		getHibernateTemplate().save(User);
		return UserVO;
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