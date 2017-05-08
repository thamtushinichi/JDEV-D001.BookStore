package jvd001.bookstore.app.controller.usermanagement;

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
public class UserLogin {

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
	public String login(HttpServletRequest request, @ModelAttribute("user") UserVO u) {
		try{
		if(this.UserLoginService.checkLogin(u.getUsername(), u.getPassword())==null){
			return "redirect:/aa";
		}
		else{
			return "redirect:/bookmanagement";
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/login";
	}

}
