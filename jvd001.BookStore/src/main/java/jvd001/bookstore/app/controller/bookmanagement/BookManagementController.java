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
import org.springframework.web.bind.annotation.RequestParam;

import jvd001.bookstore.app.HomeController;
import jvd001.bookstore.app.dto.BookVO;
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
	public String bookManagement(Locale locale, Model model) {
		model.addAttribute("bookVO",new BookVO());
		
		int size=this.bookmanagementService.listBooks().size();
		int numberpagerender=8;
		int pagenumber;
		if(size%2==0)
		{
			pagenumber=size/numberpagerender;
		}
		else
		{
			pagenumber=size/numberpagerender + 1;
		}
		model.addAttribute("listBook",this.bookmanagementService.getBooksStandard(2, 8));
		model.addAttribute("sizeListBook", size);
		model.addAttribute("pagenumber", pagenumber);
		//int so=page;
		//System.out.println(so);
//		request.setAttribute("sumpage", pagenumber);
//		request.setAttribute("sizeListBook", size);
		
		return "/bookstore/bookmanagement/bookmanagement";
	}
	
}
