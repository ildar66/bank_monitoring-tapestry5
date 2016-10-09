package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.List;

import ru.ildar66.bm.common.entity.Contractor;
import ru.ildar66.bm.common.entity.Currency;
import ru.ildar66.bm.common.entity.Deal;
import ru.ildar66.bm.common.entity.DealType;
import ru.ildar66.bm.common.instance.DealInstance;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;

/**
 * MocDAO for instance Deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealDaoMockImpl implements DealDao {
	private List<DealInstance> dealInstances = new ArrayList<DealInstance>();

	public DealDaoMockImpl() {
		initMockData();
	}

	private void initMockData() {
		addInstance(new DealInstance(new Deal("contractNumber", 1000L, Currency.EUR, DealType.CREDIT), new Contractor(
				"contractorName_1")));
		addInstance(new DealInstance(new Deal("contractNumber", 2000L, Currency.RUR, DealType.ACCREDITIVE),
				new Contractor("contractorName_2")));
		addInstance(new DealInstance(new Deal("contractNumber", 3000L, Currency.USD, DealType.CREDIT), new Contractor(
				"contractorName_3")));
	}

	public List<DealInstance> getInstances(int startIndex, int amount, EventsByDealFilter filter) {
		List<DealInstance> matches = new ArrayList<DealInstance>();
		int start = 0;
		for (DealInstance inst : dealInstances) {
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

	public void addInstance(DealInstance di) {
		// long newId = dealInstances.size();
		// di.setId(newId);
		dealInstances.add(di);
	}

}
