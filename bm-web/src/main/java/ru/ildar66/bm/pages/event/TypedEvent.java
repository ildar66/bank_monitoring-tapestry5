package ru.ildar66.bm.pages.event;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import ru.ildar66.bm.common.entity.EType;
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
	
	@Property
	@Persist(PersistenceConstants.FLASH)
	private EType selectedEventType;
	
	public void onValueChangedFromEventTypeSelect(EType et) {
		System.out.println("+++++++++++++++++onValueChangedFromEventTypeSelect eventType=" + et);
		selectedEventType = et;
	}

	void onPrepare() {
		if (event == null) {
			event = new BmEvent();
		}
	}

	public boolean isEventPersisted() {
		return (event != null) && (event.getId() != null);
	}

	void onValidateFromForm() {
		System.out.println("====================onValidateFromForm event=" + event);
	}

	void onSuccess() {
		// set type for event only ones.
		if (!isEventPersisted()) {
			event.setEventType(selectedEventType);
		}

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
