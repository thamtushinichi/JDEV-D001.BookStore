package jvd001.bookstore.app.controller.classification;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.service.classification.CategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CategoryController {
	private CategoryService categoryService;

	@Autowired(required = true)
	@Qualifier(value = "categoryService")

	public void setPersonService(CategoryService ps) {
		this.categoryService = ps;
	}

	@RequestMapping(value = "/categorymanagement/category", method = RequestMethod.GET)
	public String listCategory(Model model, HttpServletRequest request) {
		model.addAttribute("category", new Category());
		model.addAttribute("listCategory", this.categoryService.listCategory());
		UserVO user = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		model.addAttribute("userVO", user);
		try {

			if (!StringUtils.isEmpty(user.getUsername())) {
				return "/bookstore/categorymanagement/category";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/";
		}
		return "/bookstore/categorymanagement/category";
	}

	// For add and update category both
	@RequestMapping(value = "/categorymanagement/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category p, Model model, HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		model.addAttribute("userVO", user);
		boolean x = false;
		int y = 0;
		List<Category> categorys = new ArrayList<Category>();
		categorys = this.categoryService.listCategory();
		for (Category category : categorys) {
			if (category.getCategory_name().equalsIgnoreCase(p.getCategory_name())) {
				x = true;
				y = category.getCategory_id();
				break;
			}
		}
		if (x == true) {
			model.addAttribute("error_msg", "Duplicate name in ID=" + y + " !!!");
			model.addAttribute("category", new Category());
			model.addAttribute("listCategory", this.categoryService.listCategory());
			return "/bookstore/categorymanagement/category";
		}
		if ((p.getCategory_name().isEmpty() == true)) {
			model.addAttribute("error_msg", "Please input a name!!!");
			model.addAttribute("category", new Category());
			model.addAttribute("listCategory", this.categoryService.listCategory());
			return "/bookstore/categorymanagement/category";
		}
		if ((p.getCategory_id() == 0)) {
			// new category, add id
			this.categoryService.addCategory(p);
		} else {
			// existing category, call update
			this.categoryService.updateCategory(p);
		}

		return "redirect:/categorymanagement/category";

	}

	@RequestMapping("/categorymanagement/category/remove/{id}")
	public String removeCategory(@PathVariable("id") int id, HttpServletRequest request, Model model) {
		UserVO user = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		model.addAttribute("userVO", user);
		this.categoryService.removeCategory(id);
		return "redirect:/categorymanagement/category";
	}

	@RequestMapping("/categorymanagement/category/edit/{id}")

	public String editCategory(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		model.addAttribute("userVO", user);
		model.addAttribute("category", this.categoryService.getCategoryById(id));
		model.addAttribute("listCategory", this.categoryService.listCategory());

		return "/bookstore/categorymanagement/category";
	}

}
