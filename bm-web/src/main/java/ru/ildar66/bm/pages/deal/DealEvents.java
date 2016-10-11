package ru.ildar66.bm.pages.deal;

import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;
import org.apache.tapestry5.internal.services.StringValueEncoder;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.util.EnumSelectModel;

import ru.ildar66.bm.common.entity.Currency;
import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;
import ru.ildar66.bm.common.util.SortCriterion;
import ru.ildar66.bm.common.util.SortUtil;
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
	@Inject
	private BeanModelSource beanModelSource;

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
		System.out.println("The form was submitted!");
	}

	@OnEvent(value = EventConstants.SELECTED, component = "clearFilterButtonForDeal")
	void clearFilter() {
		filter = emptyFilter();
	}

	private EventsByDealFilter emptyFilter() {
		EventsByDealFilter filter = new EventsByDealFilter();
		return filter;
	}

	/*
	 * public List<DealEvent> getDealEvents() { int amount = 10; return dealDao.getDealEvents(0, amount, filter); }
	 */

	public GridDataSource getDealEvents() {
		return new GridDataSource() {
			private int startIndex;
			private List<DealEvent> instances;

			// @Override
			public int getAvailableRows() {
				return dealDao.getDealEventCount(filter);
			}

			// @Override
			public void prepare(int startIndex, int endIndex, List<SortConstraint> sortConstraints) {
				this.startIndex = startIndex;
				List<SortCriterion> sortCriteria = SortUtil.toSortCriteria(sortConstraints);
				instances = dealDao.getDealEvents(startIndex, endIndex - startIndex + 1, filter, sortCriteria);
			}

			// @Override
			public Object getRowValue(int index) {
				return instances.get(index - startIndex);
			}

			// @Override
			public Class<?> getRowType() {
				return DealEvent.class;
			}
		};
	}

	public BeanModel<DealEvent> getDealEventModel() {
		BeanModel<DealEvent> eventModel = beanModelSource.createDisplayModel(DealEvent.class, messages);
		for (String prop : eventModel.getPropertyNames()) {
			eventModel.get(prop).sortable(true);
		}
		return eventModel;
	}

	public SelectModel getCurrencies() {
		return new EnumSelectModel(Currency.class, messages);
	}

}
