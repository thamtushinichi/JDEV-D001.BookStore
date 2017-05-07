package jvd001.bookstore.app.controller.bookmanagement;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;

@Controller
public class AddBookController {
	
	private BookManagementService bookmanagementService;
	
	@Autowired(required=true)
	@Qualifier(value="bookmanagementService")
	public void setBookManagementService(BookManagementService bookmanagementService) {
		this.bookmanagementService = bookmanagementService;
	}
	
	@RequestMapping(value = "/bookmanagement/addbook", method = RequestMethod.GET)
	public String addbook(Locale locale, Model model) {
		return "/bookstore/bookmanagement/insertbook";
	}
	
	@RequestMapping(value= "/bookmanagement/addbook/save", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") BookVO book){
	
		try {
			this.bookmanagementService.addBook(book);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "redirect:/bookmanagement/addbook";
		
	}
}
