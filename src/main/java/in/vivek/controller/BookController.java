package in.vivek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.vivek.Repo.Book;
import in.vivek.service.BookServiceInterface;

@Controller
public class BookController {
	
	@Autowired
	private BookServiceInterface bsi;
	

	
	@GetMapping("/books")
	public ModelAndView getAllBooks() {
		
		ModelAndView mav = new ModelAndView();
		List<Book> allBooks = bsi.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/addBook")
	public ModelAndView addNewBook() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", new Book());
		mav.setViewName("addBook");
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView saveBook(Book book) {
		
		ModelAndView mav = new ModelAndView();
		//System.out.println(book);
		boolean saveBook = bsi.saveBook(book);
		if(saveBook)
			mav.addObject("smsg","Book Saved");
		else
			mav.addObject("fmsg","Book not saved");
		mav.setViewName("addBook");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBookById(@RequestParam(value ="bookId")  Integer bookId) {
		bsi.deleteBookById(bookId);
		ModelAndView mav = new ModelAndView();
		
		List<Book> allBooks = bsi.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView editById(@RequestParam(value ="bookId")Integer id) {
		Book bookObj = bsi.FindBookById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", bookObj);
		mav.setViewName("addBook");
		return mav;
		
	}
	
	
}
