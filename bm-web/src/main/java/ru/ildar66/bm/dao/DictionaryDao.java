package ru.ildar66.bm.dao;

import java.util.List;

import ru.ildar66.bm.common.entity.Client;

/**
 * DAO for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public interface DictionaryDao {

	public List<Client> getClients(int startIndex, int i, String clientNamePattern);

	public int getClientCount(String clientNamePattern);

}
