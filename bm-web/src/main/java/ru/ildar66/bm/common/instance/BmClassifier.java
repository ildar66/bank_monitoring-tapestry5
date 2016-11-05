package ru.ildar66.bm.common.instance;

import ru.ildar66.bm.common.entity.EventType;
import ru.ildar66.bm.common.entity.EventTypeGroup;
import ru.ildar66.bm.common.entity.MonitoredObjectType;

/**
 * Bank monitoring Classifier instance.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class BmClassifier {
	private MonitoredObjectType monitoredObjectType;
	private EventTypeGroup eventTypeGroup;
	private EventType eventType;

	public MonitoredObjectType getMonitoredObjectType() {
		return monitoredObjectType;
	}

	public void setMonitoredObjectType(MonitoredObjectType monitoredObjectType) {
		this.monitoredObjectType = monitoredObjectType;
	}

	public EventTypeGroup getEventTypeGroup() {
		return eventTypeGroup;
	}

	public void setEventTypeGroup(EventTypeGroup eventTypeGroup) {
		this.eventTypeGroup = eventTypeGroup;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
}
