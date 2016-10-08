package ru.ildar66.bm.pages.deal;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.internal.services.StringValueEncoder;

import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;

/**
 * Page events for deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealEvents {
	@Persist(PersistenceConstants.FLASH)
	@Property
	private EventsByDealFilter filter;
	
	@Property
    private final StringValueEncoder stringValueEncoder = new StringValueEncoder();

	@OnEvent(value = EventConstants.ACTIVATE)
	void prepare() {
		if (filter == null) {
			filter = emptyFilter();
		}
	}

	private EventsByDealFilter emptyFilter() {
		EventsByDealFilter filter = new EventsByDealFilter();
		return filter;
	}

}
