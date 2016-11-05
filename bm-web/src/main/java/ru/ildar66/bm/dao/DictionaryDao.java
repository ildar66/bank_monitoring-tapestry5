package ru.ildar66.bm.dao;

import java.util.List;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.common.entity.EventType;
import ru.ildar66.bm.common.entity.EventTypeGroup;
import ru.ildar66.bm.common.entity.MonitoredObjectType;
import ru.ildar66.bm.common.entity.User;

/**
 * DAO for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public interface DictionaryDao {

	public List<Client> getClients(int startIndex, int amount, String clientNamePattern);

	public int getClientCount(String clientNamePattern);

	public List<User> getUsers(int startIndex, int amount, String namePattern);

	public int getUserCount(String namePattern);

	public User getUserById(Long id);

	public List<MonitoredObjectType> getMonitoredObjectTypes();

	public List<EventTypeGroup> getEventTypeGroups(Long monitoredObjectTypeId);

	public List<EventType> getEventTypes(Long eventTypeGroupId);

}
