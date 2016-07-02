package libraryapp.domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private final Book hashCodeTestBook = new Book.Builder("Hey").barcode("9781409011446-1").build();
	private Book book = new Book.Builder("The Lost Witch").barcode("9781409011446-1").build();
	private Book book2 = new Book.Builder("The Lost Happy").barcode("9781409011446-1").build();
	private int generatedHashCode;

	@Before
	public void setUp() {
		this.generatedHashCode = hashCodeTestBook.hashCode();

	}

	@Test
	public void twoEqualBooks() {
		assertTrue(book.equals(book2));
	}

	@Test
	public void hashCodeEquality() {
		assertEquals(generatedHashCode, book.hashCode());
		assertEquals(generatedHashCode, book2.hashCode());
	}

}
