package jvd001.bookstore.app.controller.bookmanagement;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.model.usermanagement.User;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;

@Controller
public class AddBookController {

	private BookManagementService bookmanagementService;

	@Autowired(required = true)
	@Qualifier(value = "bookmanagementService")
	public void setBookManagementService(BookManagementService bookmanagementService) {
		this.bookmanagementService = bookmanagementService;
	}

	@RequestMapping(value = "/bookmanagement/addbook", method = RequestMethod.GET)
	public String addbook(Locale locale, Model model) {
		return "/bookstore/bookmanagement/insertbook";
	}

	@RequestMapping(value = "/bookmanagement/addbook/save", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("bookVO") BookVO bookVO) {
		// get user infor
		User user = new User();
		user.setUsers_id(1);
		bookVO.setUser(user);

		Set<Category> categorys = new HashSet<Category>();
		Category category = null;
		// set category
		for (int i = 0; i < bookVO.getCategory_Ids().size(); i++) {
			category = new Category();
			category.setCategory_id(bookVO.getCategory_Ids().get(i));
			// add category to set category
			 categorys.add(category);
		}
		bookVO.setCategories(categorys);
		try {

			this.bookmanagementService.addBook(bookVO);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "redirect:/bookmanagement/addbook";

	}
}
