package libraryapp.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.Objects;

public class Book {
	// ID
	private final String barcode;
	
	private final String title;
	private final String author;
	private boolean reserved;
	private final String isbn10;
	private final String isbn13;
	private final BookCategory category;
	
	@Override
	public boolean equals(Object o) {
		 if (o == null) return false;
	     if (o.getClass() != this.getClass()) return false;
	     if (o == this) return true;
	     
	     Book rhs = (Book) o;
	     return new EqualsBuilder().
	    		 append(barcode, rhs.barcode).isEquals();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(barcode);
	}
	
	public static class Builder {
		private final String title;
		
		private String author;
		private String barcode;
		private boolean reserved;
		private String isbn10;
		private String isbn13;
		private BookCategory category;
		
		public Builder(String title) {
			this.title = title;
		}
		
		public Builder author(String author) {
			this.author = author;
			return this;
		}
		
		public Builder barcode(String barcode) {
			this.barcode = barcode;
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
		
		public Book build() {
			return new Book(this);
		}	
	} // end static Builder
	
	private Book(Builder builder) {
		this.title = builder.title;
		this.author = builder.author;
		this.barcode = builder.barcode;
		this.reserved = builder.reserved;
		this.isbn10 = builder.isbn10;
		this.isbn13 = builder.isbn13;
		this.category = builder.category;
	}
}
