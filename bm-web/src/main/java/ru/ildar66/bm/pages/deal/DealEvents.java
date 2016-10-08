package ru.ildar66.bm.pages.deal;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;

/**
 * Page events for deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealEvents {
	@Persist
	@Property
	private EventsByDealFilter filter;

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
