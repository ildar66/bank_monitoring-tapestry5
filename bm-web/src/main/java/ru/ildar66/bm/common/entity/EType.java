package ru.ildar66.bm.common.entity;

import java.util.ArrayList;
import java.util.List;
import static ru.ildar66.bm.common.entity.EventGroup.*;

/**
 * Event Type.
 * 
 * @author Shafigullin Ildar
 * 
 */
public enum EType {
	PROPER_CREDIT_USE_CLIENT_EVENT_TYPE_ONE(PROPER_CREDIT_USE_CLIENT), PROPER_CREDIT_USE_CLIENT_EVENT_TYPE_TWO(PROPER_CREDIT_USE_CLIENT),
	PAYMENT_OBLIGATION_CLIENT_EVENT_TYPE_ONE(PAYMENT_OBLIGATION_CLIENT), PAYMENT_OBLIGATION_CLIENT_EVENT_TYPE_TWO(PAYMENT_OBLIGATION_CLIENT),
	PROPER_CREDIT_USE_DEAL_EVENT_TYPE_ONE(PROPER_CREDIT_USE_DEAL), PROPER_CREDIT_USE_DEAL_EVENT_TYPE_TWO(PROPER_CREDIT_USE_DEAL),
	PAYMENT_OBLIGATION_DEAL_EVENT_TYPE_ONE(PAYMENT_OBLIGATION_DEAL), PAYMENT_OBLIGATION_DEAL_EVENT_TYPE_TWO(PAYMENT_OBLIGATION_DEAL),
	PROPER_CREDIT_USE_SUPPLY_EVENT_TYPE_ONE(PROPER_CREDIT_USE_SUPPLY), PROPER_CREDIT_USE_SUPPLY_EVENT_TYPE_TWO(PROPER_CREDIT_USE_SUPPLY),
	PAYMENT_OBLIGATION_SUPPLY_EVENT_TYPE_ONE(PAYMENT_OBLIGATION_SUPPLY), PAYMENT_OBLIGATION_SUPPLY_EVENT_TYPE_TWO(PAYMENT_OBLIGATION_SUPPLY);
	private final EventGroup eventGroup;

	private EType(EventGroup eg) {
		eventGroup = eg;
	}

	public EventGroup getEventGroup() {
		return eventGroup;
	}

	public final static List<EType> getSybTypes(EventGroup eg) {
		List<EType> subTypes = new ArrayList<EType>();
		for (EType group : EType.values()) {
			if (group.getEventGroup() == eg) {
				subTypes.add(group);
			}
		}
		return subTypes;
	}
}
