package ru.ildar66.bm.pages.deal;

import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValidationTracker;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.corelib.components.TextField;
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

	@Environmental
	private ValidationTracker validationTracker;

	@InjectComponent
	private TextField amountFromInput;
	@InjectComponent
	private TextField amountToInput;

	@OnEvent(value = EventConstants.ACTIVATE)
	void prepare() {
		if (filter == null) {
			filter = emptyFilter();
		}
	}

	@OnEvent(value = EventConstants.VALIDATE, component = "searchEventsForm")
	void crossFormValidation() {
		if (validationTracker.inError(amountFromInput)) {
			validationTracker.recordError(amountFromInput, messages.get("amountFrom-wrong"));
		}
		if (validationTracker.inError(amountToInput)) {
			validationTracker.recordError(amountToInput, messages.get("amountTo-wrong"));
		}
		if (!filter.isValid()) {
			validationTracker.recordError("Date period wrong");
		}
	}

	@OnEvent(value = EventConstants.SUCCESS, component = "searchEventsForm")
	void performSearch() {
		System.out.println("The form was SUCCESS submitted!");
	}

	@OnEvent(value = EventConstants.SELECTED, component = "clearFilterButtonForDeal")
	void clearFilter() {
		validationTracker.clear();
		filter = emptyFilter();
	}

	void onSelectedFromClientDictionary(String id, String name) {
		filter.setClientName(name);
	}

	private EventsByDealFilter emptyFilter() {
		EventsByDealFilter filter = new EventsByDealFilter();
		return filter;
	}

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
