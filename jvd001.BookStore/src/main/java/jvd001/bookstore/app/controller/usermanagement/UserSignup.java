package jvd001.bookstore.app.controller.usermanagement;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.HomeController;
import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.service.usermanagement.UserSignupService;

@Controller
public class UserSignup {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	public String signup(HttpServletRequest request, @ModelAttribute("user") UserVO u) {
		UserSignupService.ExecuteSignup(u);
		return "redirect:/login";
	}
}
