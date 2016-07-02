package libraryapp.domain.model;

import java.util.List;

public class User {
	
	private long memberAccountId;
	private int loanLimit;
	private MemberCategory category;
	//private Department department;
	
	private List<Book> borrowedBooks;
	
	public void borrow(Book b) {
		if(borrowedBooks.size() >= loanLimit) {
			throw new RuntimeException("You cannot borrow more books");
		}
	}
	

}
