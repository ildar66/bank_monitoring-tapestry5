package ru.ildar66.bm.services.impl;

import org.apache.tapestry5.ValueEncoder;

import ru.ildar66.bm.common.entity.NotificationRecipient;
import ru.ildar66.bm.dao.DealDao;

/**
 * ValueEncoder for NotificationRecipient(dealEvent)
 * 
 * @author Shafigullin Ildar
 * 
 */
public class NotificationRecipientEncoder implements ValueEncoder<NotificationRecipient> {
	private DealDao dao;

	public NotificationRecipientEncoder(DealDao dealDao) {
		dao = dealDao;
	}

	public String toClient(NotificationRecipient value) {
		return String.valueOf(value.getId());
	}

	public NotificationRecipient toValue(String clientValue) {
		return dao.getNotificationRecipientById(clientValue);
	}

}
