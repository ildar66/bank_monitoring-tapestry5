package ru.ildar66.bm.dao;

import java.util.List;
import java.util.Map;

import ru.ildar66.bm.common.entity.Client;

/**
 * DAO implementation for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DictionaryDaoImpl implements DictionaryDao {
	private Map<String, String> sql;

	public List<Client> getClients(int startIndex, int i, String clientNamePattern) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getClientCount(String clientNamePattern) {
		// TODO Auto-generated method stub
		System.out.println(sql);
		return 0;
	}

	public void setSql(Map<String, String> sql) {
		this.sql = sql;
	}

}
