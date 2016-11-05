package ru.ildar66.bm.common.entity;

import java.util.ArrayList;
import java.util.List;
import static ru.ildar66.bm.common.entity.MonitoredObject.*;

/**
 * Event Type group.
 * 
 * @author Shafigullin Ildar
 * 
 */
public enum EventGroup {
	PROPER_CREDIT_USE_CLIENT(CLIENT), PAYMENT_OBLIGATION_CLIENT(CLIENT),
	PROPER_CREDIT_USE_DEAL(DEAL), PAYMENT_OBLIGATION_DEAL(DEAL),
	PROPER_CREDIT_USE_SUPPLY(SYPPLY), PAYMENT_OBLIGATION_SUPPLY(SYPPLY);

	private final MonitoredObject monitoredObject;

	private EventGroup(MonitoredObject mo) {
		monitoredObject = mo;
	}

	public MonitoredObject getMonitoredObject() {
		return monitoredObject;
	}

	public final static List<EventGroup> getSubGroup(MonitoredObject mo) {
		List<EventGroup> subGroup = new ArrayList<EventGroup>();
		for (EventGroup group : EventGroup.values()) {
			if (group.getMonitoredObject() == mo) {
				subGroup.add(group);
			}
		}
		return subGroup;
	}
}
