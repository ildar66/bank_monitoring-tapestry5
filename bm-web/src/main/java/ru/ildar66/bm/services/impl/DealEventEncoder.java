package ru.ildar66.bm.services.impl;

import org.apache.tapestry5.ValueEncoder;

import ru.ildar66.bm.common.instance.DealEvent;
import ru.ildar66.bm.dao.DealDao;

/**
 * ValueEncoder for deal event
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealEventEncoder implements ValueEncoder<DealEvent> {
	private DealDao dao;

	public DealEventEncoder(DealDao dealDao) {
		dao = dealDao;
	}

	public String toClient(DealEvent value) {
		return String.valueOf(value.getId());
	}

	public DealEvent toValue(String clientValue) {
		Long id = Long.valueOf(clientValue);

		return dao.getDealEventById(id);
	}

}
