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

import org.apache.commons.io.FilenameUtils;
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
import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.model.bookmanagement.Upload;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.model.usermanagement.User;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;
import jvd001.bookstore.app.service.classification.CategoryService;
import jvd001.bookstore.app.util.ConvertUtils;

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
	public String addbook(Locale locale, Model model, HttpServletRequest request) {
		List<Category> categoryLists = new ArrayList<Category>();
		categoryLists = this.categoryService.listCategory();
		model.addAttribute("categoryLists", categoryLists);
		UserVO user = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		model.addAttribute("userVO", user);
		return "/bookstore/bookmanagement/insertbook";
	}

	@RequestMapping(value = "/bookmanagement/addbook/save", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("bookVO") BookVO bookVO,HttpServletRequest request,RedirectAttributes rd, Model model) {
		// get user infor
		UserVO userVO = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		User user = ConvertUtils.convertUserVOToUser(userVO);
		model.addAttribute("userVO", userVO);
//		user.setUsers_id(1);
		bookVO.setUser(user);
		try {
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
//			int bookId = 0;
			int bookId = this.bookmanagementService.getMaxId() + 1;
			//set book
	        Set<Upload> uploads = new HashSet<Upload>();
	        Upload upload = new Upload();
	        //set upload file name
	        upload.setUpload_File_Name(bookVO.getBook().getOriginalFilename());
	        //set upload file show
	        String fileNameBookUpLoad = bookId + bookVO.getBook().getOriginalFilename();
	        upload.setFile_Name(fileNameBookUpLoad);
	        //set extension
	        String extention = FilenameUtils.getExtension(bookVO.getBook().getOriginalFilename());
	        upload.setExtension(extention);
	        upload.setUsers_Id(bookVO.getUser().getUsers_id());
	        uploads.add(upload);
	        bookVO.setUploads(uploads);
	        
	        //save book
			String fileName = null;
			//image upload
		if(!bookVO.getFile().isEmpty()){
	        try {
	        	String path = request.getSession().getServletContext().getRealPath("");
	        	fileName = bookVO.getFile().getOriginalFilename();
	            byte[] bytes = bookVO.getFile().getBytes();
	            BufferedOutputStream buffStream = 
	                    new BufferedOutputStream(new FileOutputStream(new File(path + "resources\\images\\" + bookId + fileName)));
	            buffStream.write(bytes);
	            buffStream.close();
	        } catch (Exception e) {
	            return "You failed to upload " + fileName + ": " + e.getMessage();
	        }
		}
		//set image name
		bookVO.setImage(bookId + bookVO.getFile().getOriginalFilename());
		
		String fileNameBook = null;
		if(!bookVO.getBook().isEmpty()){
	        try {
	        	String path = request.getSession().getServletContext().getRealPath("");
	        	fileNameBook = bookVO.getBook().getOriginalFilename();
	            byte[] bytes = bookVO.getBook().getBytes();
	            BufferedOutputStream buffStream = 
	                    new BufferedOutputStream(new FileOutputStream(new File(path + "resources\\book\\" + bookId + fileNameBook)));
	            buffStream.write(bytes);
	            buffStream.close();
	        } catch (Exception e) {
	            return "You failed to upload " + fileName + ": " + e.getMessage();
	        }
	        bookId = this.bookmanagementService.addBook(bookVO);
		}

			rd.addFlashAttribute("message", 1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rd.addFlashAttribute("message", 2);
		}

		return "redirect:/bookmanagement/addbook";

	}
}
