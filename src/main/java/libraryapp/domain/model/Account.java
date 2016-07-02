package libraryapp.domain.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long memberAccountId;
	private int loanLimit;
	private MemberCategory category;
	
	@Transient
	private List<Book> borrowedBooks;
	
	public void borrow(Book b) {
		if(borrowedBooks.size() >= loanLimit) {
			throw new RuntimeException("You cannot borrow more books");
		}
	}
	

}
