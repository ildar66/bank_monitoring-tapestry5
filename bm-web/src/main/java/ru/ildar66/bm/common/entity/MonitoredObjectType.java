package ru.ildar66.bm.common.entity;

/**
 * Event Monitored object instance.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class MonitoredObjectType extends IndexedEntity<Long>{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
