package ru.ildar66.bm.services.impl;

import org.apache.tapestry5.ValueEncoder;

import ru.ildar66.bm.common.entity.User;
import ru.ildar66.bm.dao.DictionaryDao;

/**
 * ValueEncoder for User
 * 
 * @author Shafigullin Ildar
 * 
 */
public class UserEncoder implements ValueEncoder<User> {
	private DictionaryDao dao;

	public UserEncoder(DictionaryDao dictionaryDao) {
		dao = dictionaryDao;
	}

	public String toClient(User value) {
		return String.valueOf(value.getId());
	}

	public User toValue(String clientValue) {
		Long id = Long.valueOf(clientValue);
		return dao.getUserById(id);
	}

}
