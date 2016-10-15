package ru.ildar66.bm.dao;

import java.util.ArrayList;
import java.util.List;

import ru.ildar66.bm.common.entity.Contractor;

/**
 * Mock DAO for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DictionaryDaoMockImpl implements DictionaryDao {
	private List<Contractor> dealEvents = new ArrayList<Contractor>();

	public DictionaryDaoMockImpl() {
		initMockData();
	}

	private void initMockData() {
		for (int i = 0; i < 10; i++) {
			dealEvents.add(new Contractor("clientName_" + i));
		}
	}

	public List<Contractor> getContractors(int startIndex, int i, String contractorNamePattern) {
		return dealEvents;
	}

	public int getContractorCount(String contractorNamePattern) {
		return dealEvents.size();
	}

}
