package jvd001.bookstore.app.controller.classification;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.service.classification.CategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CategoryController {
	private CategoryService categoryService;
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	
	public void setPersonService(CategoryService ps){
		this.categoryService = ps;
	}
	
	@RequestMapping(value = "/categorymanagement/category", method = RequestMethod.GET)
	public String listCategory( Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("listCategory", this.categoryService.listCategory());
		return "/bookstore/categorymanagement/category";
	}
}
