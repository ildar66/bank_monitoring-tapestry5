package ru.ildar66.bm.dao;

import java.util.List;

import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;

/**
 * DAO for instance Deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public interface DealDao {

	List<DealEvent> getDealEvents(int startIndex, int amount, EventsByDealFilter filter);
}
