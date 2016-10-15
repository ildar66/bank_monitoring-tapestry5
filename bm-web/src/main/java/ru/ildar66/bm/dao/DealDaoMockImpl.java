package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.common.entity.Currency;
import ru.ildar66.bm.common.entity.Deal;
import ru.ildar66.bm.common.entity.DealType;
import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;
import ru.ildar66.bm.common.util.SortCriterion;
import ru.ildar66.bm.common.util.SortDirection;

/**
 * MocDAO for instance Deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealDaoMockImpl implements DealDao {
	private List<DealEvent> dealEvents = new ArrayList<DealEvent>();

	public DealDaoMockImpl() {
		initMockData();
	}

	private void initMockData() {
		final long NOW = System.currentTimeMillis();
		final int DAY = 24 * 60 * 60 * 1000;
		for (int i = 1; i <= 100; i++) {
			DealEvent event1 = new DealEvent(new Deal("contractNumber " + 10 * i, 1000L, Currency.EUR, DealType.CREDIT,
					new Date(NOW - DAY)), new Client("clientName_1"));
			event1.setStatus("ALL CRF");
			addEvent(event1);
			DealEvent event2 = new DealEvent(new Deal("contractNumber " + 20 * i, 2000L, Currency.RUR,
					DealType.ACCREDITIVE, new Date()), new Client("clientName_3"));
			event2.setStatus("Overdue KE");
			addEvent(event2);
			addEvent(new DealEvent(new Deal("contractNumber " + 30 * i, 3000L, Currency.USD, DealType.CREDIT, new Date(
					NOW + DAY)), new Client("clientName_5")));
		}
	}

	public List<DealEvent> getDealEvents(int startIndex, int amount, EventsByDealFilter filter,
			List<SortCriterion> sortCriteria) {
		sort(dealEvents, sortCriteria);
		List<DealEvent> matches = new ArrayList<DealEvent>();
		int start = 0;
		for (DealEvent inst : dealEvents) {
			/* page list and filter precondition checks */
			if (filter.match(inst) && ++start > startIndex) {
				matches.add(inst);
			}
			if (matches.size() == amount) {
				return matches;
			}
		}
		return matches;
	}

	private void sort(List<DealEvent> list, List<SortCriterion> sortCriteria) {
		if (!sortCriteria.isEmpty()) {
			SortCriterion sortCriterion = sortCriteria.get(0);
			String propertyName = sortCriterion.getPropertyName();
			SortDirection sortDirection = sortCriterion.getSortDirection();
			Comparator<DealEvent> cmp = null;
			if ("id".equalsIgnoreCase(propertyName)) {
				cmp = new Comparator<DealEvent>() {
					public int compare(DealEvent e1, DealEvent e2) {
						return (int) (e1.getId() - e2.getId());
					}
				};
			} else if ("status".equalsIgnoreCase(propertyName)) {
				cmp = new Comparator<DealEvent>() {
					public int compare(DealEvent e1, DealEvent e2) {
						return (int) (e1.getStatus().compareTo(e2.getStatus()));
					}
				};
			} else {
				System.err.printf("Comparator for %s not implemented ", propertyName);
				return;
			}
			if (sortDirection == SortDirection.ASCENDING) {
				Collections.sort(list, cmp);
			} else {
				Collections.sort(list, Collections.reverseOrder(cmp));
			}
		}
	}

	public int getDealEventCount(EventsByDealFilter filter) {
		int result = 0;
		for (DealEvent event : dealEvents) {
			if (filter.match(event)) {
				result++;
			}
		}
		return result;

	}

	private void addEvent(DealEvent di) {
		long newId = dealEvents.size() + 1;
		di.setId(newId);
		dealEvents.add(di);
	}

}
