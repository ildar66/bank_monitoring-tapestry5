package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.common.entity.EventType;
import ru.ildar66.bm.common.entity.EventTypeGroup;
import ru.ildar66.bm.common.entity.MonitoredObjectType;
import ru.ildar66.bm.common.entity.User;

/**
 * Mock DAO for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DictionaryDaoMockImpl implements DictionaryDao {
	public final static String ALL_PATTERN = "*";
	private List<Client> clients;
	private List<User> users;
	private List<MonitoredObjectType> monitoredObjectTypes;
	private Map<Long, List<EventTypeGroup>> eventTypeGroups;
	private Map<Long, List<EventType>> eventTypes;

	public DictionaryDaoMockImpl() {
		super();
	}

	public void setEventTypeGroups(Map<Long, List<EventTypeGroup>> eventTypeGroups) {
		this.eventTypeGroups = eventTypeGroups;
	}

	public void setMonitoredObjectTypes(List<MonitoredObjectType> monitoredObjectTypes) {
		this.monitoredObjectTypes = monitoredObjectTypes;
	}

	public void setEventTypes(Map<Long, List<EventType>> eventTypes) {
		this.eventTypes = eventTypes;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Client> getClients(int startIndex, int amount, String clientNamePattern) {
		List<Client> matches = new ArrayList<Client>();
		for (Client client : clients) {
			if (isMatch(clientNamePattern, client)) {
				matches.add(client);
			}
		}
		return matches;
	}

	private boolean isMatch(String clientNamePattern, Client client) {
		if (clientNamePattern.equals(ALL_PATTERN)) {
			return true;
		}
		return clientNamePattern != null && client.getName().contains(clientNamePattern);
	}

	public int getClientCount(String clientNamePattern) {
		int result = 0;
		for (Client client : clients) {
			if (isMatch(clientNamePattern, client)) {
				result++;
			}
		}
		return result;
	}

	public List<User> getUsers(int startIndex, int amount, String namePattern) {
		List<User> matches = new ArrayList<User>();
		for (User user : users) {
			if (isMatch(namePattern, user)) {
				matches.add(user);
			}
		}
		return matches;
	}

	private boolean isMatch(String namePattern, User user) {
		if (namePattern.equals(ALL_PATTERN)) {
			return true;
		}
		return namePattern != null && user.getName().contains(namePattern);
	}

	public int getUserCount(String namePattern) {
		int result = 0;
		for (User user : users) {
			if (isMatch(namePattern, user)) {
				result++;
			}
		}
		return result;
	}

	public User getUserById(Long id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public List<MonitoredObjectType> getMonitoredObjectTypes() {
		return monitoredObjectTypes;
	}

	public List<EventTypeGroup> getEventTypeGroups(Long monitoredObjectTypeId) {
		return eventTypeGroups.get(monitoredObjectTypeId);
	}

	public List<EventType> getEventTypes(Long eventTypeGroupId) {
		return eventTypes.get(eventTypeGroupId);
	}

}
