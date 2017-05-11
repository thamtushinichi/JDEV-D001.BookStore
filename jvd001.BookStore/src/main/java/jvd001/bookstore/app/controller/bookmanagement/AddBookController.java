package jvd001.bookstore.app.controller.bookmanagement;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.dto.CategoryVO;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.model.usermanagement.User;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;
import jvd001.bookstore.app.service.classification.CategoryService;

@Controller
public class AddBookController {

	private static final Logger logger = LoggerFactory.getLogger(AddBookController.class);
	
	private BookManagementService bookmanagementService;
	@Autowired(required = true)
	@Qualifier(value = "bookmanagementService")
	public void setBookManagementService(BookManagementService bookmanagementService) {
		this.bookmanagementService = bookmanagementService;
	}
	
	private CategoryService categoryService;
	@Autowired(required = true)
	@Qualifier(value = "categoryService")
	public void setCategorySevice(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "/bookmanagement/addbook", method = RequestMethod.GET)
	public String addbook(Locale locale, Model model) {
		List<Category> categoryLists = new ArrayList<Category>();
		categoryLists = this.categoryService.listCategory();
		model.addAttribute("categoryLists", categoryLists);
		return "/bookstore/bookmanagement/insertbook";
	}

	@RequestMapping(value = "/bookmanagement/addbook/save", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("bookVO") BookVO bookVO,HttpServletRequest request,RedirectAttributes rd) {
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
		String fileName = null;
		if (!bookVO.getFile().isEmpty()) {
	            try {
	            	fileName = bookVO.getFile().getOriginalFilename();
	                byte[] bytes = bookVO.getFile().getBytes();
	                BufferedOutputStream buffStream = 
	                        new BufferedOutputStream(new FileOutputStream(new File("I:/Java/" + fileName)));
	                buffStream.write(bytes);
	                buffStream.close();
	                bookVO.setImage(fileName);
	            } catch (Exception e) {
	                return "You failed to upload " + fileName + ": " + e.getMessage();
	            }
	        } else {
	            return "Unable to upload. File is empty.";
	        }
		try {

			this.bookmanagementService.addBook(bookVO);
			rd.addFlashAttribute("message", 1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rd.addFlashAttribute("message", 2);
		}

		return "redirect:/bookmanagement/addbook";

	}
}
