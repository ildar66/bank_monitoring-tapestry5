package ru.ildar66.bm.pages.event;

import java.util.List;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import ru.ildar66.bm.common.entity.EType;
import ru.ildar66.bm.common.entity.EventGroup;
import ru.ildar66.bm.common.entity.MonitoredObject;
import ru.ildar66.bm.common.instance.BmEvent;
import ru.ildar66.bm.dao.EventDao;

/**
 * Create enum typed bank monitoring event.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class TypedEvent {
	@Property
	@PageActivationContext(passivate = false)
	private BmEvent event;

	@Inject
	private EventDao eventDao;

	@Inject
	private Messages messages;

	@Inject
	private ComponentResources componentResources;

	@Property
	@Persist(PersistenceConstants.FLASH)
	private String message;

	@Persist
	@Property
	private MonitoredObject monitoredObject;

	@Persist
	@Property
	private EventGroup eventGroup;

	@Persist
	@Property
	private EType eventType;

	@InjectComponent
	private Zone groupTypeZone;

	public List<EventGroup> getEventGroupModel() {
		return EventGroup.getSubGroup(monitoredObject);
	}

	public List<EType> getEventTypeModel() {
		return EType.getSybTypes(eventGroup);
	}

	public Object onValueChangedFromMonitoredObject(MonitoredObject mo) {
		eventGroup = null;
		eventType = null;
		return groupTypeZone.getBody();
	}

	public Object onValueChangedFromEventGroup(EventGroup eg) {
		eventType = null;
		return groupTypeZone.getBody();
	}

	void onPrepare() {
		if (event == null) {
			event = new BmEvent();
		}
	}

	public boolean isEventPersisted() {
		return (event != null) && (event.getId() != null);
	}

	void onSuccess() {
		event.setEventType(eventType);

		eventDao.persist(event);

		componentResources.discardPersistentFieldChanges();

		message = messages.format("event-persisted", event.getEventType());

	}

	Object[] onPassivate() {
		if (isEventPersisted()) {
			return new Object[] { event };
		}

		return new Object[] {};
	}

}
