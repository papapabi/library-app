package libraryapp.infrastructure.jpa;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import libraryapp.domain.model.Book;
import libraryapp.domain.model.BookCategory;
import libraryapp.interfaces.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/libraryapp/interfaces/BorrowingServiceFacadeTests-context.xml" })
@Transactional
public class JpaBookRepositoryTests {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Before
	public void setUpBooksAndCopies() {
		// TODO Set-up the following books (and their copies), and categories
		// NOTE: All these book copies are IN (not borrowed/checked-out).

		// An entityManager field has already been defined in the base class.
		// So, you can use it here.
		// entityManager.persist(entity);

		/*
		 * title: The Affair
		 * author: Lee Child
		 * published month: September
		 * published year: 2011
		 * isbn: 1409011445, 9781409011446
		 * category: Novel
		 * copies: 9781409011446-1, 9781409011446-2
		 */
		Book theAffair = new Book.Builder("The Affair", "9781409011446-1")
				.author("Lee Child")
				.isbn10Number("1409011445")
				.isbn13Number("9781409011446")
				.category(BookCategory.NOVEL)
				.build();
		Book theAffair2 = new Book.Builder("The Affair", "9781409011446-2")
				.author("Lee Child")
				.isbn10Number("1409011445")
				.isbn13Number("9781409011446")
				.category(BookCategory.NOVEL)
				.build();
		/*
		 * title: A Wanted Man
		 * author: Lee Child
		 * published month: August
		 * published year: 2012
		 * isbn: 037369606X, 9780373696062
		 * category: Novel
		 * copies: 9780373696062-1
		 */
		Book aWantedMan = new Book.Builder("A Wanted Man", "9780373696062-1")
				.author("Lee Child")
				.isbn10Number("037369606X")
				.isbn13Number("9780373696062")
				.category(BookCategory.NOVEL)
				.build();
		/*
		 * title: Inferno
		 * author: Dan Brown
		 * published month: May
		 * published year: 2013
		 * isbn: 0593075005, 9780593075005
		 * category: Novel
		 * copies: 9780593075005-1, 9780593075005-2
		 */
		Book inferno = new Book.Builder("Inferno", "9780593075005-1")
				.author("Dan Brown")
				.isbn10Number("0593075005")
				.isbn13Number("9780593075005")
				.category(BookCategory.NOVEL)
				.build();
		Book inferno2 = new Book.Builder("Inferno", "9780593075005-2")
				.author("Dan Brown")
				.isbn10Number("0593075005")
				.isbn13Number("9780593075005")
				.category(BookCategory.NOVEL)
				.build();
		/*
		 * title: The Lost Symbol
		 * author: Dan Brown
		 * published month: September
		 * published year: 2009
		 * isbn: 055217002X, 9780552170024
		 * category: Novel
		 * copies: 9780552170024-1, 9780552170024-2
		 */
		Book theLostSymbol = new Book.Builder("The Lost Symbol", "9780552170024-1")
				.author("Dan Brown")
				.isbn10Number("055217002X")
				.isbn13Number("9780552170024")
				.category(BookCategory.NOVEL)
				.build();
		Book theLostSymbol2 = new Book.Builder("The Lost Symbol", " 9780552170024-2")
				.author("Dan Brown")
				.isbn10Number("055217002X")
				.isbn13Number("9780552170024")
				.category(BookCategory.NOVEL)
				.build();
		/*
		 * title: Diary of a Wimpy Kid
		 * author: Jeff Kinney
		 * published month: April
		 * published year: 2007
		 * isbn: 0141324902, 9780141324906
		 * category: Comedy
		 * copies: 9780141324906-1, 9780141324906-2
		 */
		Book diaryOfWimpyKid = new Book.Builder("Diary of a Wimpy Kid", "9780141324906-1")
				.author("Jeff Kinney")
				.isbn10Number("0141324902")
				.isbn13Number("9780141324906-2")
				.category(BookCategory.COMEDY)
				.build();
		Book diaryOfWimpyKid2 = new Book.Builder("Diary of a Wimpy Kid", "9780141324906-2")
				.author("Jeff Kinney")
				.isbn10Number("0141324902")
				.isbn13Number("9780141324906-2")
				.category(BookCategory.COMEDY)
				.build();
		/*
		 * title: Advanced Grammar in Use
		 * author: Martin Hewings
		 * published year: 2005
		 * isbn: 3125341477, 9783125341470
		 * category: Reference
		 * copies: 9783125341470-1
		 */
		Book advancedGrammar = new Book.Builder("Advanced Grammar in Use", "9783125341470-1")
				.author("Martin Hewings")
				.isbn10Number("3125341477")
				.isbn13Number("9783125341470")
				.category(BookCategory.REFERENCE)
				.build();
		
		entityManager.persist(theAffair);
		entityManager.persist(theAffair2);
		entityManager.persist(aWantedMan);
		entityManager.persist(inferno);
		entityManager.persist(inferno2);
		entityManager.persist(theLostSymbol);
		entityManager.persist(theLostSymbol2);
		entityManager.persist(diaryOfWimpyKid);
		entityManager.persist(diaryOfWimpyKid2);
		entityManager.persist(advancedGrammar);
	}

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void findBookByBarcode() {
		Book advancedGrammar = bookRepository.getBook("9783125341470-1");
		assertNotNull(advancedGrammar);
		assertEquals("Advanced Grammar in Use", advancedGrammar.getTitle());
		assertEquals("Martin Hewings", advancedGrammar.getAuthor());
		assertEquals("3125341477", advancedGrammar.getIsbn10());
		assertEquals("9783125341470", advancedGrammar.getIsbn13());
		assertEquals(BookCategory.REFERENCE, advancedGrammar.getCategory());
		System.out.println(advancedGrammar);
	}

}
