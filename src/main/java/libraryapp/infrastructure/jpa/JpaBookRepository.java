package libraryapp.infrastructure.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import libraryapp.domain.model.Book;
import libraryapp.interfaces.BookRepository;

@Repository
public class JpaBookRepository implements BookRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Book> getBooks() {
		return entityManager.createQuery
				("SELECT b FROM book b", Book.class).getResultList();
	}

	@Override
	public Book getBook(String barcode) {
		TypedQuery<Book> query = entityManager.createQuery
				("SELECT b FROM Book b WHERE b.barcode = :barcode", Book.class);
		query.setParameter("barcode", barcode);
		return query.getSingleResult();	
	}
}
