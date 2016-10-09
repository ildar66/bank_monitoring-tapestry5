package ru.ildar66.bm.dao;

import java.util.List;

import ru.ildar66.bm.common.instance.DealInstance;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;

/**
 * DAO for instance Deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public interface DealDao {

	List<DealInstance> getInstances(int startIndex, int amount, EventsByDealFilter filter);
}
