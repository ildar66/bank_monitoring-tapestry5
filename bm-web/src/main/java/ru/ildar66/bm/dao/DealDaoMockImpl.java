package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.ildar66.bm.common.entity.Contractor;
import ru.ildar66.bm.common.entity.Currency;
import ru.ildar66.bm.common.entity.Deal;
import ru.ildar66.bm.common.entity.DealType;
import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;

/**
 * MocDAO for instance Deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealDaoMockImpl implements DealDao {
	private List<DealEvent> dealInstances = new ArrayList<DealEvent>();

	public DealDaoMockImpl() {
		initMockData();
	}

	private void initMockData() {
		DealEvent event1 = new DealEvent(new Deal("contractNumber", 1000L, Currency.EUR, DealType.CREDIT, new Date()),
				new Contractor("contractorName_1"));
		event1.setStatus("ALL CRF");
		addInstance(event1);
		DealEvent event2 = new DealEvent(new Deal("contractNumber", 2000L, Currency.RUR, DealType.ACCREDITIVE, new Date()),
				new Contractor("contractorName_2"));
		event2.setStatus("Overdue KE");
		addInstance(event2);
		addInstance(new DealEvent(new Deal("contractNumber", 3000L, Currency.USD, DealType.CREDIT, new Date()),
				new Contractor("contractorName_3")));
	}

	public List<DealEvent> getDealEvents(int startIndex, int amount, EventsByDealFilter filter) {
		List<DealEvent> matches = new ArrayList<DealEvent>();
		int start = 0;
		for (DealEvent inst : dealInstances) {
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

	public void addInstance(DealEvent di) {
		// long newId = dealInstances.size();
		// di.setId(newId);
		dealInstances.add(di);
	}

}
