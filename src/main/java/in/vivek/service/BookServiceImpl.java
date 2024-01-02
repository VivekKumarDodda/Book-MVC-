package in.vivek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import in.vivek.Repo.Book;
import in.vivek.Repo.BookRepo;

@Service
public class BookServiceImpl implements BookServiceInterface {
	
	@Autowired
	private BookRepo brepo;
	@Override
	public boolean saveBook(Book book) {
		
		Book save = brepo.save(book);
		
		return true;
	}
	@Override
	public List<Book> getAllBooks() {
		List<Book> findAll = brepo.findAll();
		return findAll;
	}
	
	


	@Override
	public void deleteBookById(Integer id) {
		brepo.deleteById(id);
	}
	@Override
	public Book FindBookById(Integer id) {
		Optional<Book> findById = brepo.findById(id);
		if(findById.isPresent())
			return findById.get();
		else
			return null;
		
	}
	
}
