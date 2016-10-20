package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.List;

import ru.ildar66.bm.common.entity.Client;

/**
 * Mock DAO for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DictionaryDaoMockImpl implements DictionaryDao {
	public final static String ALL_CLIENTS_PATTERN = "*";
	private List<Client> clients;

	public DictionaryDaoMockImpl() {
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
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
		if (clientNamePattern.equals(ALL_CLIENTS_PATTERN)) {
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

}
