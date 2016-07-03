package libraryapp.domain.model;

import java.time.Month;
import java.time.YearMonth;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity // creates a table named "Book"
public class Book {
	private static final Book NONE = new Book.Builder("N/A", "N/A").build();
	private static final String NIL_ISBN = "ISBN not available.";
	
	// the columns of table "Book" are as follows, with no modifications to their names
	@Id private String barcode;
	@Basic private String title;
	private String author;
	private boolean reserved;
	private String isbn10;
	private String isbn13;
	@Enumerated(EnumType.STRING)
	private BookCategory category;
	@Version
	private Integer version;
	
	@org.hibernate.annotations.Columns(columns={
			@Column(name="month", nullable=false, length=2),
			@Column(name="year", nullable=false, length=4)
			})
	private YearMonth datePublished;
	
	public Book() {
		
	}
	
	@Override
	public boolean equals(Object o) {
		 if (o == null) return false;
	     if (o.getClass() != this.getClass()) return false;
	     if (o == this) return true;
	     
	     Book rhs = (Book) o;
	     return new EqualsBuilder().
	    		 append(barcode, rhs.barcode).
	    		 isEquals();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(barcode);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("Barcode", this.barcode)
		.add("Title", this.title)
		.add("Author", this.author)
		.add("Reserved?", this.reserved)
		.toString();
	}
	
	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public BookCategory getCategory() {
		return category;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}

	public static class Builder {
		private final String title;
		private final String barcode;
		
		private String author = "N/A";
		private boolean reserved = false;
		private String isbn10 = Book.NIL_ISBN;
		private String isbn13 = Book.NIL_ISBN;
		private BookCategory category = BookCategory.NONE;
		private YearMonth datePublished = YearMonth.of(2016, Month.JANUARY);
		
		public Builder(String title, String barcode) {
			this.title = title;
			this.barcode = barcode;
		}
		
		public Builder author(String author) {
			this.author = author;
			return this;
		}
		
		public Builder isReserved(boolean value) {
			this.reserved = value;
			return this;
		}
		
		public Builder isbn10Number(String value) {
			this.isbn10 = value;
			return this;
		}
		
		public Builder isbn13Number(String value) {
			this.isbn13 = value;
			return this;
		}
		
		public Builder category(BookCategory category) {
			this.category = category;
			return this;
		}
		
		public Builder datePublished(YearMonth datePublished) {
			this.datePublished = datePublished;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}	
	} // end static Builder
	
	private Book(Builder builder) {
		this.barcode = builder.barcode;
		this.title = builder.title;
		this.author = builder.author;
		this.reserved = builder.reserved;
		this.isbn10 = builder.isbn10;
		this.isbn13 = builder.isbn13;
		this.category = builder.category;
		this.datePublished = builder.datePublished;
	}
}
