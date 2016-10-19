package ru.ildar66.bm.dao;

import java.util.List;
import java.util.Map;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.dao.util.AbstractDao;

/**
 * DAO implementation for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DictionaryDaoImpl extends AbstractDao implements DictionaryDao {

	public List<Client> getClients(int startIndex, int i, String clientNamePattern) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getClientCount(String clientNamePattern) {
		// TODO Auto-generated method stub
		System.out.println(sql);
		return 0;
	}

}
