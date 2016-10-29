package ru.ildar66.bm.pages.event;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import ru.ildar66.bm.common.entity.NotificationRecipient;
import ru.ildar66.bm.common.entity.User;
import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.dao.DealDao;

//import org.apache.tapestry5.annotations.SessionState;

/**
 * Create bank monitoring event
 * 
 * @author Shafigullin Ildar
 * 
 */
public class CreateEvent {
	@Property
	@PageActivationContext(passivate = false)
	private DealEvent event;

	@Property
	private NotificationRecipient currentRecipient;

	// @SessionState
	@Inject
	private DealDao dealDao;

	@Inject
	private Messages messages;

	@Property
	@Persist(PersistenceConstants.FLASH)
	private String message;

	void onPrepare() {
		if (event == null) {
			event = new DealEvent();
		}
	}

	public boolean isEventPersisted() {
		return (event != null) && (event.getId() != null);
	}

	Object onAddRowFromRecipients() {
		NotificationRecipient recipient = new NotificationRecipient();

		event.getRecipients().add(recipient);

		dealDao.persist(event);

		return recipient;
	}

	void onRemoveRowFromRecipients(final NotificationRecipient recipient) {
		event.getRecipients().remove(recipient);

		dealDao.persist(event);
	}

	void onSuccess() {
		dealDao.persist(event);

		message = messages.format("event-persisted", event.getRecipients().size());
	}

	Object[] onPassivate() {
		if (isEventPersisted()) {
			return new Object[] { event };
		}

		return new Object[] {};
	}

	void onSelectedFromUserDictionary(User selectedUser) {
		NotificationRecipient recipient = new NotificationRecipient(selectedUser.getName(), selectedUser.getEmail());

		event.getRecipients().add(recipient);

		dealDao.persist(event);

		message = messages.format("event-persisted", event.getRecipients().size());
	}

}
