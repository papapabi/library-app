package libraryapp.domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private final Book hashCodeTestBook = new Book.Builder("Hey", "9781409011446-1").build();
	private Book book = new Book.Builder("The Lost Witch", "9781409011446-1").build();
	private Book book2 = new Book.Builder("The Lost Happy", "9781409011446-2").build();
	private int generatedHashCode;

	@Before
	public void setUp() {
		this.generatedHashCode = hashCodeTestBook.hashCode();

	}

	@Test
	public void hashCodeEquality() {
		assertEquals(generatedHashCode, book.hashCode());
	}
	
	
	@Test
	public void toStringTest() {
		assertEquals("Book{Barcode=9781409011446-1, "
				+ "Title=The Lost Witch, Author=null, "
				+ "Reserved?=false}", book.toString());
	}
}
