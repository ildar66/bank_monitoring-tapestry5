package ru.ildar66.bm.common.entity;

/**
 * Event Type instance.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class EventType extends IndexedEntity<Long> {
	private String name;
	private EventTypeGroup eventTypeGroup;

	public EventTypeGroup getEventTypeGroup() {
		return eventTypeGroup;
	}

	public void setEventTypeGroup(EventTypeGroup eventTypeGroup) {
		this.eventTypeGroup = eventTypeGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
