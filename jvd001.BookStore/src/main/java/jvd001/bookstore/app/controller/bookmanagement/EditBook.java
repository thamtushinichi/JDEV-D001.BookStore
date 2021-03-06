package jvd001.bookstore.app.controller.bookmanagement;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.HomeController;

@Controller
public class EditBook {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/bookmanagement/editbook/{id}", method = RequestMethod.GET)
	public String login(Locale locale, Model model,@PathVariable String id) {
		return "/bookstore/bookmanagement/editbook";
	}

}
