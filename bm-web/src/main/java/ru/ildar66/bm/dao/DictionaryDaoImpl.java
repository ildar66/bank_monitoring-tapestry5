package ru.ildar66.bm.dao;

import java.util.List;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.dao.mapper.ClientRowMapper;
import ru.ildar66.bm.dao.util.AbstractDao;

/**
 * DAO implementation for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DictionaryDaoImpl extends AbstractDao implements DictionaryDao {

	public List<Client> getClients(int startIndex, int amount, String clientNamePattern) {
		Object[] args = { clientNamePattern };
		return getJdbcTemplate().query(sql.get("CLIENTS_BY_NAME"), args, ClientRowMapper.INSTANCE);
	}

	public int getClientCount(String clientNamePattern) {
		Object[] args = { clientNamePattern };
		return getJdbcTemplate().queryForInt(sql.get("CLIENTS_BY_NAME_COUNT"), args);
	}

}