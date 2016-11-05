package ru.ildar66.bm.common.instance;

import ru.ildar66.bm.common.entity.EType;

/**
 * bank monitoring event instance.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class BmEvent {
	private final static String EVENT_STATUS_NEW = "NEW";

	private Long id;
	private String name;
	private String status = EVENT_STATUS_NEW;

	private final BmClassifier classifier = new BmClassifier();

	private EType eventType;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BmClassifier getClassifier() {
		return classifier;
	}

	public EType getEventType() {
		return eventType;
	}

	public void setEventType(EType eventType) {
		this.eventType = eventType;
	}

}
