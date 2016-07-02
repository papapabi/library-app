package libraryapp.domain.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.MonthDay;
import java.time.YearMonth;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

public class PersistentYearMonthAsIntegers implements CompositeUserType {

	@Override
	public String[] getPropertyNames() {
		// Ordering is important, you must match the
		// order and spelling of the names defined in the property mapping
		return new String[] {"month", "year"};
	}

	@Override
	public Type[] getPropertyTypes() {
		return new Type[] { IntegerType.INSTANCE, IntegerType.INSTANCE };
	}

	@Override
	public Object getPropertyValue(Object component, int propertyIndex) throws HibernateException {
		if(component == null) {
			return null;
		}
		YearMonth yearMonth = (YearMonth) component;
		switch(propertyIndex) {
		case 0: 
			// first attribute in column is the month, so return it at index 0
			yearMonth.getMonthValue();
		case 1:
			yearMonth.getYear();
		default:
			// otherwise, an exception is thrown
			throw new HibernateException(
					"Invalid property index [" + propertyIndex + "]" );
		}
	}

	@Override
	public void setPropertyValue(Object arg0, int arg1, Object arg2) throws HibernateException {
		// This should not be called if #isMutable() returns false.
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return java.time.YearMonth.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if ((x == null) && (y == null)) {
			return true;
		}
	    if ((x == null) || (y == null)) {
	        return false;
	    }
	    return x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		assert names.length == 2;
		Integer month = (Integer) IntegerType.INSTANCE.get(rs, names[0], session);
		Integer year = (Integer) IntegerType.INSTANCE.get(rs, names[1], session);
		if (month == null || year == null) {
			return null;
		}
		YearMonth yearMonth = YearMonth.of(year, month);
		return yearMonth;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			IntegerType.INSTANCE.set(st, null, index, session);
			IntegerType.INSTANCE.set(st, null, index + 1, session);
		} else {
			YearMonth yearMonth = (YearMonth) value;
			IntegerType.INSTANCE.set(st, yearMonth.getMonthValue(), index, session);
			IntegerType.INSTANCE.set(st, yearMonth.getYear(), index + 1, session);
		}	
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value; // since object is immutable
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value, SessionImplementor session) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, SessionImplementor session, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, SessionImplementor session, Object owner) 
			throws HibernateException {
		return original;
	}
}
