package ru.ildar66.bm.pages.event;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import ru.ildar66.bm.common.instance.BmEvent;
import ru.ildar66.bm.dao.EventDao;

//import org.apache.tapestry5.annotations.SessionState;

/**
 * Create bank monitoring event from classifier fields.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class ClassifierEvent {
	@Property
	@Persist
	@PageActivationContext(passivate = false)
	private BmEvent event;

	// @SessionState
	@Inject
	private EventDao eventDao;

	@Inject
	private Messages messages;

	@Inject
	private ComponentResources componentResources;

	@Property
	@Persist(PersistenceConstants.FLASH)
	private String message;

	void onPrepare() {
		if (event == null) {
			event = new BmEvent();
		}
	}

	public boolean isEventPersisted() {
		return (event != null) && (event.getId() != null);
	}

	void onSuccess() {
		eventDao.persist(event);

		componentResources.discardPersistentFieldChanges();

		message = messages.format("event-persisted", event.getClassifier().getEventType().getName());

	}

	Object[] onPassivate() {
		if (isEventPersisted()) {
			return new Object[] { event };
		}

		return new Object[] {};
	}

}
