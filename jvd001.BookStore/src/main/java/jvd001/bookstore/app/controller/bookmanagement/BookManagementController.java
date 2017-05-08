package jvd001.bookstore.app.controller.bookmanagement;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jvd001.bookstore.app.dto.BookSearchCondition;
import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;

@Controller
@SessionAttributes("bookSearchCondition")
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
		model.addAttribute("listBook",this.bookmanagementService.getBooksStandard(1, numberpagerender));
		model.addAttribute("sizeListBook", size);
		model.addAttribute("pagenumber", pagenumber);
		//int so=page;
		//System.out.println(so);
//		request.setAttribute("sumpage", pagenumber);
//		request.setAttribute("sizeListBook", size);
		
		return "/bookstore/bookmanagement/bookmanagement";
	}
	@RequestMapping(value="/bookmanagement/{page}", method=RequestMethod.GET)
	public  String bookManagementByPage(@PathVariable String page,Locale locale, Model model,@ModelAttribute("bookSearchCondition") BookSearchCondition sc )
	{
		
		System.out.println(sc.getCategory_name());
		System.out.println(sc.getTitle());
		System.out.println(sc.getPublisher());
		System.out.println(sc.getYear_of_publishing());
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
		int iPage= Integer.parseInt(page.trim());
		System.out.println("page la: "+ iPage);
		model.addAttribute("listBook",this.bookmanagementService.getBooksStandard(iPage, numberpagerender));
		model.addAttribute("sizeListBook", size);
		model.addAttribute("pagenumber", pagenumber);
		return "bookstore/bookmanagement/bookmanagement";
	}
	@RequestMapping(value="/bookmanagement/search/", method=RequestMethod.POST)
	public  String search(Locale locale, Model model,@ModelAttribute("bookSearchCondition") BookSearchCondition sc )
	{
		
//		System.out.println(sc.getCategory_name());
//		System.out.println(sc.getTitle());
//		System.out.println(sc.getPublisher());
//		System.out.println(sc.getYear_of_publishing());
		
		List<BookVO> listBookTitle = bookmanagementService.getListBookByTitle(sc);
		if(listBookTitle!=null)
		{
			for(int i=0;i<listBookTitle.size();i++)
			{
				System.out.println(listBookTitle.get(i).toString());
			}
		}
		else
		{
			System.out.println("ko lay duoc du lieu");
		}
				return null;
	}
}
