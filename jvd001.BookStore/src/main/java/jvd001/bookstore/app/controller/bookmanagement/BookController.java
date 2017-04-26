package jvd001.bookstore.app.controller.bookmanagement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.HomeController;
@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/bookmanagement", method = RequestMethod.GET)
	public String bookManagement(Locale locale, Model model) {

		return "/bookstore/bookmanagement/bookmanagement";
	}
}
