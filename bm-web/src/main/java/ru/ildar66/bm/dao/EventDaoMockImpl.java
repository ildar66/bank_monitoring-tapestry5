package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.List;

import ru.ildar66.bm.common.instance.BmEvent;

public class EventDaoMockImpl implements EventDao {
	private List<BmEvent> bmEvents = new ArrayList<BmEvent>();

	public void persist(BmEvent event) {
		Long id = event.getId();
		if (id == null) {
			addEvent(event);
		} else {
			// TODO
		}
	}

	private void addEvent(BmEvent event) {
		long newId = bmEvents.size() + 1;
		event.setId(newId);
		bmEvents.add(event);
	}

	public BmEvent getBmEventById(Long id) {
		for (BmEvent event : bmEvents) {
			if (event.getId().equals(id)) {
				return event;
			}
		}
		return null;
	}

}
