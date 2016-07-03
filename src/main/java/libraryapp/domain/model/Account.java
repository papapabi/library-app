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
	
	public Account() {
		
	}
	
	public Account(MemberCategory category) {
		this.category = category;
		this.loanLimit = category.getLoanLimit();
	}
	
	public void borrow(Book b) {
		if(borrowedBooks.size() >= loanLimit) {
			throw new RuntimeException("You cannot borrow more books");
		}
	}
	
	public int getLoanLimit() {
		return loanLimit;
	}
	
	public long getMemberAccountId() {
		return memberAccountId;
	}
	
	public MemberCategory getCategory() {
		return category;
	}
}
