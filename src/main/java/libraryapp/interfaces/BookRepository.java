package libraryapp.interfaces;

import java.util.List;

import libraryapp.domain.model.Book;


public interface BookRepository {
	public List<Book> getBooks();
	
	public Book getBook(String barcode);
}
