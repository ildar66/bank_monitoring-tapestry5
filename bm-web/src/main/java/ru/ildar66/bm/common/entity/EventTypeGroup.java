package ru.ildar66.bm.common.entity;

/**
 * Event Type group instance.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class EventTypeGroup extends IndexedEntity<Long> {
	private String name;
	private MonitoredObjectType monitoredObjectType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MonitoredObjectType getMonitoredObjectType() {
		return monitoredObjectType;
	}

	public void setMonitoredObjectType(MonitoredObjectType monitoredObjectType) {
		this.monitoredObjectType = monitoredObjectType;
	}
}
