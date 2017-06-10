package jvd001.bookstore.app.controller.bookmanagement;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jvd001.bookstore.app.dto.BookSearchCondition;
import jvd001.bookstore.app.dto.BookVO;
import jvd001.bookstore.app.dto.CategoryVO;
import jvd001.bookstore.app.dto.UserVO;
import jvd001.bookstore.app.model.classification.Category;
import jvd001.bookstore.app.service.bookmanagement.BookManagementService;
import jvd001.bookstore.app.service.classification.CategoryService;

@Controller
// @SessionAttributes("bookSearchCondition")
public class BookManagementController {
	private BookManagementService bookmanagementService;
	private CategoryService categoryService;
	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	public CategoryService getCategoryService() {
		return categoryService;
	}

	@Autowired(required = true)
	@Qualifier(value = "categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public BookManagementService getBookService() {
		return bookmanagementService;
	}

	@Autowired(required = true)
	@Qualifier(value = "bookmanagementService")
	public void setBookService(BookManagementService bookmanagementService) {
		this.bookmanagementService = bookmanagementService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexBookmanagement(Locale locale, Model model, HttpServletRequest request) {
		// set path
		request.getSession().setAttribute("path", request.getSession().getServletContext().getRealPath(""));
		model.addAttribute("path", request.getSession().getServletContext().getRealPath(""));
		// end set path
		// check login
		UserVO userVO = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		if (userVO != null)
			model.addAttribute("userVO", userVO);
		else
			model.addAttribute("userVO", null);
		// clear session

		//
		BookSearchCondition sc = new BookSearchCondition();
		sc.setCategory_id(0);
		sc.setPublisher("");
		sc.setTitle("");
		sc.setYear_of_publishing("");

		if (sc != null) {
			// System.out.println("bookmanagemt/"+page+","+bsc.getCategory_id()+","
			// +bsc.getTitle()+","
			// +bsc.getPublisher()+","+bsc.getYear_of_publishing());
			model.addAttribute("bsc", sc);
		}
		request.getSession().setAttribute("bookSearchCondition", sc);
		int size = (int) this.bookmanagementService.getSize_By_SearchCondition_Per_Page(sc);

		int numberpagerender = 8;
		int pagenumber;
		if (size % numberpagerender == 0) {
			pagenumber = size / numberpagerender;
		} else {
			pagenumber = size / numberpagerender + 1;
		}

		model.addAttribute("bookVO", new BookVO());
		model.addAttribute("listBook",
				this.bookmanagementService.getListBook_By_SearchCondition_Per_Page(sc, 1, numberpagerender));
		model.addAttribute("sizeListBook", size);
		model.addAttribute("pagenumber", pagenumber);
		model.addAttribute("category", new Category());
		model.addAttribute("listCategory", this.categoryService.listCategory());

		return "/bookstore/bookmanagement/bookmanagement";
	}

	@RequestMapping(value = "/bookmanagement", method = RequestMethod.GET)
	public String bookManagement(Locale locale, Model model, HttpServletRequest request) {

		UserVO userVO = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		if (userVO != null)
			model.addAttribute("userVO", userVO);
		else
			model.addAttribute("userVO", null);
		BookSearchCondition sc = new BookSearchCondition();
		sc.setCategory_id(0);
		sc.setPublisher("");
		sc.setTitle("");
		sc.setYear_of_publishing("");

		if (sc != null) {
			model.addAttribute("bsc", sc);
		}
		request.getSession().setAttribute("bookSearchCondition", sc);
		int size = (int) this.bookmanagementService.getSize_By_SearchCondition_Per_Page(sc);

		int numberpagerender = 8;
		int pagenumber;
		if (size % numberpagerender == 0) {
			pagenumber = size / numberpagerender;
		} else {
			pagenumber = size / numberpagerender + 1;
		}

		model.addAttribute("bookVO", new BookVO());
		model.addAttribute("listBook",
				this.bookmanagementService.getListBook_By_SearchCondition_Per_Page(sc, 1, numberpagerender));
		model.addAttribute("sizeListBook", size);
		model.addAttribute("pagenumber", pagenumber);
		model.addAttribute("category", new Category());
		model.addAttribute("listCategory", this.categoryService.listCategory());

		return "/bookstore/bookmanagement/bookmanagement";
	}

	@RequestMapping(value = "/bookmanagement/{page}", method = RequestMethod.GET)
	public String bookManagementByPage(@PathVariable String page, Locale locale, Model model,
			@ModelAttribute("bookSearchCondition") BookSearchCondition sc, HttpServletRequest request) {
		// BookSearchCondition sc= new BookSearchCondition();
		// sc.setCategory_id(0);
		// sc.setPublisher("");
		// sc.setTitle("");
		// sc.setYear_of_publishing("");
		UserVO userVO = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		if (userVO != null)
			model.addAttribute("userVO", userVO);
		else
			model.addAttribute("userVO", null);
		sc = (BookSearchCondition) request.getSession().getAttribute("bookSearchCondition");
		if (sc != null) {
			model.addAttribute("bsc", sc);
		} else {
			sc = new BookSearchCondition();
			sc.setCategory_id(0);
		}
		int size = (int) this.bookmanagementService.getSize_By_SearchCondition_Per_Page(sc);
		int numberpagerender = 8;
		int pagenumber;
		if (size % numberpagerender == 0) {
			pagenumber = size / numberpagerender;
		} else {
			pagenumber = size / numberpagerender + 1;
		}
		int iPage = Integer.parseInt(page.trim());
		System.out.println("page la: " + iPage);
		model.addAttribute("listBook",
				this.bookmanagementService.getListBook_By_SearchCondition_Per_Page(sc, iPage, numberpagerender));
		model.addAttribute("sizeListBook", size);
		model.addAttribute("pagenumber", pagenumber);
		model.addAttribute("listCategory", this.categoryService.listCategory());
		return "bookstore/bookmanagement/bookmanagement";
	}

	@RequestMapping(value = "/bookmanagement/search/", method = RequestMethod.POST)
	public String search(Locale locale, Model model,
			@ModelAttribute("bookSearchCondition") BookSearchCondition bookSearchCondition,
			HttpServletRequest request) {
		UserVO userVO = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		if (userVO != null)
			model.addAttribute("userVO", userVO);
		else
			model.addAttribute("userVO", null);
		request.getSession().setAttribute("bookSearchCondition", bookSearchCondition);
		model.addAttribute("bsc", bookSearchCondition);

		List<BookVO> listBook = bookmanagementService.getListBook_By_SearchCondition_Per_Page(bookSearchCondition, 1,
				8);
		if (listBook != null) {
			int size = (int) this.bookmanagementService.getSize_By_SearchCondition_Per_Page(bookSearchCondition);
			int numberpagerender = 8;
			int pagenumber;
			if (size % numberpagerender == 0) {
				pagenumber = size / numberpagerender;
			} else {
				pagenumber = size / numberpagerender + 1;
			}
			model.addAttribute("listBook", listBook);
			model.addAttribute("sizeListBook", size);
			model.addAttribute("pagenumber", pagenumber);
			model.addAttribute("listCategory", this.categoryService.listCategory());
			return "bookstore/bookmanagement/bookmanagement";
		} else {
			model.addAttribute("listCategory", this.categoryService.listCategory());
			return "bookstore/bookmanagement/bookmanagement";
		}

	}

	@RequestMapping(value = "/bookmanagement/detail/{idbook}", method = RequestMethod.GET)
	public String detailBook(@PathVariable String idbook, Locale locale, Model model, HttpServletRequest request) {
		UserVO userVO = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		if (userVO != null)
			model.addAttribute("userVO", userVO);
		else
			model.addAttribute("userVO", null);
		System.out.println("id la: " + idbook);
		List<BookVO> bookVOs = this.bookmanagementService.getBookById(Integer.parseInt(idbook));
		if (bookVOs.size() > 0) {
			BookVO bookVO = null;
			List<Category> a = null;
			for (int i = 0; i < bookVOs.size(); i++) {
				bookVO = bookVOs.get(i);
				a = new ArrayList(bookVO.getCategories());

			}
			model.addAttribute("bookVO", bookVO);
			model.addAttribute("listCategory", a);

		}

		else {
			System.out.println("khong lay duoc");
		}
		return "bookstore/bookmanagement/detailbook";
	}

	@RequestMapping(value = "/bookmanagement/detail/download/{idbook}", method = RequestMethod.GET)
	public String getFile(HttpServletResponse response, @PathVariable String idbook, HttpServletRequest request) {
		// check login neu chua login quay lai trang login
		UserVO userVO = (UserVO) request.getSession().getAttribute("CurrentUserLogin");
		if (userVO == null) {
			// chua login thi
			return "redirect:/login";
		}

		String filename = this.bookmanagementService.getNameFile(idbook);
		System.out.println(filename);
		String path1 = request.getSession().getServletContext().getRealPath("");
		// try {
		// DefaultResourceLoader loader = new DefaultResourceLoader();
		// InputStream is =
		// loader.getResource(path+"resources\\book\\"+filename).getInputStream();
		// IOUtils.copy(is, response.getOutputStream());
		// response.setHeader("Content-Disposition", "attachment;
		// filename="+filename);
		// response.flushBuffer();
		// } catch (IOException ex) {
		// throw new RuntimeException("IOError writing file to output stream");
		// }
		// Authorized user will download the file

		try {
			String pathFile = path1 + "resources/book/" + filename;
			System.out.println(pathFile);
			File file = null;
			// ClassLoader classloader =
			// Thread.currentThread().getContextClassLoader();
			file = new File(pathFile);
			if (!file.exists()) {
				String errorMessage = "Sorry. The file you are looking for does not exist";
				System.out.println(errorMessage);
				OutputStream outputStream = response.getOutputStream();
				outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
				outputStream.close();
				return null; // tra ve trang error
			}
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				System.out.println("mimetype is not detectable, will take default");
				mimeType = "application/octet-stream";
			}
			System.out.println("mimetype : " + mimeType);

			response.setContentType(mimeType);

			/*
			 * "Content-Disposition : inline" will show viewable types [like
			 * images/text/pdf/anything viewable by browser] right on browser
			 * while others(zip e.g) will be directly downloaded [may provide
			 * save as popup, based on your browser setting.]
			 */
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

			/*
			 * "Content-Disposition : attachment" will be directly download, may
			 * provide save as popup, based on your browser setting
			 */
			// response.setHeader("Content-Disposition",
			// String.format("attachment; filename=\"%s\"", file.getName()));

			response.setContentLength((int) file.length());
			InputStream inputStream;
			inputStream = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(inputStream, response.getOutputStream());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/bookmanagement/detail/{idbook}";

		// Copy bytes from source to destination(outputstream in this example),
		// closes both streams.

	}

}
