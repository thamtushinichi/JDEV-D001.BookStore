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
import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.service.usermanagement.UserSignupService;

@Controller
public class UserLogoutController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String signup(HttpServletRequest request,Locale locale, Model model, @ModelAttribute("user") UserVO u) {
		request.getSession().removeAttribute("CurrentUserLogin");
		model.addAttribute("userVO", u);
		
		return "/bookstore/user/logout";
	}
	
	
}
