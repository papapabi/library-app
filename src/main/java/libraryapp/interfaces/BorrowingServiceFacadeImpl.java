package libraryapp.interfaces;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import libraryapp.domain.exceptions.BookIsReservedException;
import libraryapp.domain.exceptions.LoanedBookCapacityReachedException;

@Service
public class BorrowingServiceFacadeImpl implements BorrowingServiceFacade {

	@Override
	@Transactional(rollbackFor={
			LoanedBookCapacityReachedException.class,
			BookIsReservedException.class
			},
		readOnly = false,
		timeout = 30,
		propagation=Propagation.SUPPORTS,
		isolation=Isolation.DEFAULT)
	public BorrowReceipt borrowBook(String barcode, String memberAccountId) {
		
		return null;
	}

	@Override
	public void returnBook(String barcode, String memberAccountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public ReservationReceipt reserveBook(String isbn, String memberAccountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<BookLoanStatus> getBookLoanStatus(String memberAccountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
