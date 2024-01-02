package in.vivek.service;

import java.util.List;

import in.vivek.Repo.Book;

public interface BookServiceInterface {
	
	public boolean saveBook(Book book);
	
	public List<Book> getAllBooks();
	
	public void deleteBookById(Integer id);
	
	public Book FindBookById(Integer id);
	

}
