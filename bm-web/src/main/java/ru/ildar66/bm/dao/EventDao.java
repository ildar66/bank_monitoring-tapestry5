package ru.ildar66.bm.dao;

import ru.ildar66.bm.common.instance.BmEvent;

/**
 * DAO for instance bank Event
 * 
 * @author Shafigullin Ildar
 * 
 */
public interface EventDao {

	public void persist(BmEvent event);

	public BmEvent getBmEventById(Long id);

}
