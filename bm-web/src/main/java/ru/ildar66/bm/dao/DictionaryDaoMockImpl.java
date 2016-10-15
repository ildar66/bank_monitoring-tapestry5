package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.List;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.components.ClientDictionary;

/**
 * Mock DAO for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DictionaryDaoMockImpl implements DictionaryDao {
	private List<Client> clients = new ArrayList<Client>();

	public DictionaryDaoMockImpl() {
		initMockData();
	}

	private void initMockData() {
		for (int i = 0; i < 10; i++) {
			clients.add(new Client("clientName_" + i));
		}
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
		if (clientNamePattern.equals(ClientDictionary.ALL_CLIENTS_PATTERN)) {
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
