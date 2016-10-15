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
	private List<Client> dealEvents = new ArrayList<Client>();

	public DictionaryDaoMockImpl() {
		initMockData();
	}

	private void initMockData() {
		for (int i = 0; i < 10; i++) {
			dealEvents.add(new Client("clientName_" + i));
		}
	}

	public List<Client> getClients(int startIndex, int i, String clientNamePattern) {
		return dealEvents;
	}

	public int getClientCount(String clientNamePattern) {
		return dealEvents.size();
	}

}
