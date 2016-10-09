package ru.ildar66.bm.pages.deal;

import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.internal.services.StringValueEncoder;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import ru.ildar66.bm.common.entity.Currency;
import ru.ildar66.bm.common.instance.DealEvent;
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

	@Inject
	private Messages messages;

	@Persist
	@Property
	private EventsByDealFilter filter;

	@Property
	private final StringValueEncoder stringValueEncoder = new StringValueEncoder();
	@Property
	private DealEvent dealEvent;

	@OnEvent(value = EventConstants.ACTIVATE)
	void prepare() {
		if (filter == null) {
			filter = emptyFilter();
		}
	}

	@OnEvent(value = EventConstants.SUCCESS, component = "searchEventsForm")
	void performSearch() {
		// TODO: complete search, no need in this listener?
	}

	private EventsByDealFilter emptyFilter() {
		EventsByDealFilter filter = new EventsByDealFilter();
		return filter;
	}

	public List<DealEvent> getDealEvents() {
		int amount = 10;
		return dealDao.getDealEvents(0, amount, filter);
	}

	public SelectModel getCurrencies() {
		return new EnumSelectModel(Currency.class, messages);
	}

}
