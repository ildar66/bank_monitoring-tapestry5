package ru.ildar66.bm.services.impl;

import org.apache.tapestry5.ValueEncoder;

import ru.ildar66.bm.common.instance.BmEvent;
import ru.ildar66.bm.dao.EventDao;

/**
 * ValueEncoder for bank monitoring event
 * 
 * @author Shafigullin Ildar
 * 
 */
public class BmEventEncoder implements ValueEncoder<BmEvent> {
	private EventDao dao;

	public BmEventEncoder(EventDao eventDao) {
		dao = eventDao;
	}

	public String toClient(BmEvent value) {
		return String.valueOf(value.getId());
	}

	public BmEvent toValue(String clientValue) {
		Long id = Long.valueOf(clientValue);

		return dao.getBmEventById(id);
	}

}
