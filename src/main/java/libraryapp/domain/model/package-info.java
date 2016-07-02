/**
 * Contains Hibernate-specific user-defined mapping. As such, it is not portable
 * to other JPA providers.
 */
@TypeDefs({
	@TypeDef(typeClass = PersistentYearMonthAsIntegers.class,
			defaultForType = YearMonth.class)
})
package libraryapp.domain.model;


import java.time.YearMonth;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;