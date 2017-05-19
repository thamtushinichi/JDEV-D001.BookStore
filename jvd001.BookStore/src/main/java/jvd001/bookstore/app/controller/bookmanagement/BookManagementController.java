package jvd001.bookstore.app.controller.bookmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import jvd001.bookstore.app.dto.CategoryVO;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;
import jvd001.bookstore.app.service.classification.CategoryService;

@Controller
//@SessionAttributes("bookSearchCondition")
public class BookManagementController {
	private BookManagementService bookmanagementService;
	private CategoryService categoryService;
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public CategoryService getCategoryService() {
		return categoryService;
	}
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public BookManagementService getBookService() {
		return bookmanagementService;                   
	}
	@Autowired(required=true)
	@Qualifier(value="bookmanagementService")
	public void setBookService(BookManagementService bookmanagementService) {
		this.bookmanagementService = bookmanagementService;
	}

	@RequestMapping(value = "/bookmanagement", method = RequestMethod.GET)
	public String bookManagement(Locale locale, Model model, HttpServletRequest request) {
		
		BookSearchCondition sc= new BookSearchCondition();
		sc.setCategory_id(0);
		sc.setPublisher("");
		sc.setTitle("");
		sc.setYear_of_publishing("");
		
		if(sc !=null)
		{
	//	System.out.println("bookmanagemt/"+page+","+bsc.getCategory_id()+"," +bsc.getTitle()+"," +bsc.getPublisher()+","+bsc.getYear_of_publishing());
		model.addAttribute("bsc",sc);
	}
		
		int size=(int)this.bookmanagementService.getSize_By_SearchCondition_Per_Page(sc);
		
		int numberpagerender=8;
		int pagenumber;
		if(size%numberpagerender==0)
		{
			pagenumber=size/numberpagerender;
		}
		else
		{
			pagenumber=size/numberpagerender + 1;
		}
		
		model.addAttribute("bookVO",new BookVO());
		model.addAttribute("listBook",this.bookmanagementService.getListBook_By_SearchCondition_Per_Page(sc, 1, numberpagerender));
		model.addAttribute("sizeListBook", size);
		model.addAttribute("pagenumber", pagenumber);
		model.addAttribute("category",new Category());
		model.addAttribute("listCategory",this.categoryService.listCategory());
		
		
		return "/bookstore/bookmanagement/bookmanagement";
	}
	@RequestMapping(value="/bookmanagement/{page}", method=RequestMethod.GET)
	public  String bookManagementByPage(@PathVariable String page,Locale locale, Model model,@ModelAttribute("bookSearchCondition") BookSearchCondition sc,HttpServletRequest request )
	{
		//BookSearchCondition sc= new BookSearchCondition();
//		sc.setCategory_id(0);
//		sc.setPublisher("");
//		sc.setTitle("");
//		sc.setYear_of_publishing("");
		sc=(BookSearchCondition) request.getSession().getAttribute("bookSearchCondition");
		if(sc !=null)
		{
		model.addAttribute("bsc",sc);
		}
		else
		{
			sc= new BookSearchCondition();
			sc.setCategory_id(0);
		}
		int size=(int)this.bookmanagementService.getSize_By_SearchCondition_Per_Page(sc);
		int numberpagerender=8;
		int pagenumber;
		if(size%numberpagerender==0)
		{
			pagenumber=size/numberpagerender;
		}
		else
		{
			pagenumber=size/numberpagerender + 1;
		}
		int iPage= Integer.parseInt(page.trim());
		System.out.println("page la: "+ iPage);
		model.addAttribute("listBook",this.bookmanagementService.getListBook_By_SearchCondition_Per_Page(sc, iPage, numberpagerender));
		model.addAttribute("sizeListBook", size);
		model.addAttribute("pagenumber", pagenumber);
		model.addAttribute("listCategory",this.categoryService.listCategory());
		return "bookstore/bookmanagement/bookmanagement";
	}
	@RequestMapping(value="/bookmanagement/search/", method=RequestMethod.POST)
	public  String search(Locale locale, Model model,@ModelAttribute("bookSearchCondition") BookSearchCondition bookSearchCondition,HttpServletRequest request )
	{
		request.getSession().setAttribute("bookSearchCondition", bookSearchCondition);
		model.addAttribute("bsc",bookSearchCondition);
		List<BookVO> listBook = bookmanagementService.getListBook_By_SearchCondition_Per_Page(bookSearchCondition, 1, 8);
		if(listBook!=null)
		{
			int size=(int)this.bookmanagementService.getSize_By_SearchCondition_Per_Page(bookSearchCondition);
			int numberpagerender=8; 
			int pagenumber;
			if(size%numberpagerender==0)
			{
				pagenumber=size/numberpagerender;
			}
			else
			{
				pagenumber=size/numberpagerender + 1;
			}
			model.addAttribute("listBook",listBook);
			model.addAttribute("sizeListBook", size);
			model.addAttribute("pagenumber", pagenumber);
			model.addAttribute("listCategory",this.categoryService.listCategory());
			return "bookstore/bookmanagement/bookmanagement";
		}
		else
		{
			model.addAttribute("listCategory",this.categoryService.listCategory());
			return "bookstore/bookmanagement/bookmanagement";
		}
				
	}
	@RequestMapping(value="/bookmanagement/detail/{idbook}", method=RequestMethod.GET)
	public String detailBook(@PathVariable String idbook,Locale locale, Model model)
	{
		System.out.println("id la: " + idbook);
		List<BookVO> bookVOs= this.bookmanagementService.getBookById(Integer.parseInt(idbook));
		if(bookVOs.size()>0)
		{
			BookVO bookVO = null;
			List<Category> a = null;
			for(int i=0;i<bookVOs.size();i++)
			{
				 bookVO=bookVOs.get(i);
				 a= new ArrayList(bookVO.getCategories());                
				
			}
			model.addAttribute("bookVO",bookVO);
			model.addAttribute("listCategory",a);
			
		}
		
		else
		{
			System.out.println("khong lay duoc");
		}
		return "bookstore/bookmanagement/detailbook";
	}
}
