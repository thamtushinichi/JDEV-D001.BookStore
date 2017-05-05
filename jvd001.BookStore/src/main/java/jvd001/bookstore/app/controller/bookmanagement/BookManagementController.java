package jvd001.bookstore.app.controller.bookmanagement;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jvd001.bookstore.app.HomeController;
import jvd001.bookstore.app.model.bookmanagement.Book;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;

@Controller
public class BookManagementController {
	private BookManagementService bookmanagementService;
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public BookManagementService getBookService() {
		return bookmanagementService;
	}
	@Autowired(required=true)
	@Qualifier(value="bookmanagementService")
	public void setBookService(BookManagementService bookmanagementService) {
		this.bookmanagementService = bookmanagementService;
	}

	@RequestMapping(value = "/bookmanagement", method = RequestMethod.GET)
	public String bookManagement(HttpServletRequest request,Locale locale, Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("listBook",this.bookmanagementService.listBooks());
		int size=this.bookmanagementService.listBooks().size();
		
		request.setAttribute("sizeListBook", size);
		
		return "/bookstore/bookmanagement/bookmanagement";
	}
	
}
