package jvd001.bookstore.app.controller.classification;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CategoryController {
	@RequestMapping(value = "/categorymanagement/category", method = RequestMethod.GET)
	public String category(Locale locale, Model model) {
		
		return "/bookstore/categorymanagement/category";
	}
}
