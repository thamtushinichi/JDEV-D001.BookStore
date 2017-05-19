package jvd001.bookstore.app.controller.usermanagement;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.HomeController;
import jvd001.bookstore.app.dao.usermanagement.UserSignupDAOImpl;
import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.service.usermanagement.UserSignupService;

@Controller
public class UserSignupController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserSignupService UserSignupService;
	
	public UserSignupService getUserSignupService() {
		return UserSignupService;
	}

	public void setUserSignupService(UserSignupService userSignupService) {
		UserSignupService = userSignupService;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) {

		return "/bookstore/user/signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(HttpServletRequest request, Model model, @ModelAttribute("user") UserVO u) {
		String status="";
		boolean valid=UserSignupService.ExecuteSignup(u);
		
		if(!valid){
			status="Username or Email already exist!";
			model.addAttribute("status", status);
			return "/bookstore/user/signup";
		}
		
		if(valid){
		UserVO userVO=u;
		u.setPassword(null);
		model.addAttribute("userVO", userVO);
		request.getSession().setAttribute("CurrentUserLogin", userVO);
		return "redirect:/login";
		}
		return "/bookstore/user/signup";
	}
}
