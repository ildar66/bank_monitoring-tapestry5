package ru.ildar66.bm.dao;

import java.util.List;

import ru.ildar66.bm.common.entity.NotificationRecipient;
import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.common.searchfilter.EventsByDealFilter;
import ru.ildar66.bm.common.util.SortCriterion;

/**
 * DAO for instance Deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public interface DealDao {

	List<DealEvent> getDealEvents(int startIndex, int amount, EventsByDealFilter filter,
			List<SortCriterion> sortCriteria);

	int getDealEventCount(EventsByDealFilter filter);

	void persist(DealEvent event);

	DealEvent getDealEventById(Long id);

	NotificationRecipient getNotificationRecipientById(String id);

}
