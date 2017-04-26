package jvd001.bookstore.app.controller.bookmanagement;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddBook {
	
	@RequestMapping(value = "/bookmanagement/addbook", method = RequestMethod.GET)
	public String addbook(Locale locale, Model model) {
		return "/bookstore/bookmanagement/insertbook";
	}
}
