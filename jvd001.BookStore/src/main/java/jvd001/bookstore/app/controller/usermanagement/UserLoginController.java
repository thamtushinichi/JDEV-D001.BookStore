package jvd001.bookstore.app.controller.usermanagement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.HomeController;
import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.service.usermanagement.UserLoginService;

@Controller
public class UserLoginController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserLoginService UserLoginService;

	public UserLoginService getUserLoginService() {
		return UserLoginService;
	}

	public void setUserLoginService(UserLoginService userLoginService) {
		UserLoginService = userLoginService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "/bookstore/user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, @ModelAttribute("user") UserVO u,@ModelAttribute("userValid") UserVO userValid) {
		try {
			if (this.UserLoginService.checkLogin(u.getUsername(), u.getPassword()) == null) {
				return "/bookstore/user/login";
			} else {
				userValid=this.UserLoginService.checkLogin(u.getUsername(), u.getPassword());
				model.addAttribute("userVO", userValid);
				request.getSession().setAttribute("CurrentUserLogin", userValid);
				return "/bookstore/";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login";
	}

	   
}
