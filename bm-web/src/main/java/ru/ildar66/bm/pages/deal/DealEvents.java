package ru.ildar66.bm.pages.deal;

import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.internal.services.StringValueEncoder;

import ru.ildar66.bm.common.instance.DealInstance;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;
import ru.ildar66.bm.dao.DealDao;

/**
 * Page events for deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealEvents {
	@SessionState
	private DealDao dealDao;

	@Persist(PersistenceConstants.FLASH)
	@Property
	private EventsByDealFilter filter;

	@Property
	private final StringValueEncoder stringValueEncoder = new StringValueEncoder();
	@Property
	private DealInstance dealInstance;

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

	public List<DealInstance> getDealInstances() {
		int amount = 10;
		return dealDao.getInstances(0, amount, filter);
	}

}
