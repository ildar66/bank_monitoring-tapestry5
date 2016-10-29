package ru.ildar66.bm.model;

import java.util.List;

import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;

import ru.ildar66.bm.common.entity.User;
import ru.ildar66.bm.dao.DictionaryDao;

/**
 * Users DataSource.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class UserDataSource implements GridDataSource {
	private int startIndex;
	private String namePattern;
	private List<User> users;
	private DictionaryDao dictionaryDao;

	public UserDataSource(String namePattern, DictionaryDao dictionaryDao) {
		super();
		this.namePattern = namePattern;
		this.dictionaryDao = dictionaryDao;
	}

	// @Override
	public void prepare(int startIndex, int endIndex, List<SortConstraint> sortConstraints) {
		this.startIndex = startIndex;
		users = dictionaryDao.getUsers(startIndex, endIndex - startIndex + 1, namePattern);
	}

	// @Override
	public Object getRowValue(int index) {
		return users.get(index - startIndex);
	}

	// @Override
	public Class<?> getRowType() {
		return User.class;
	}

	// @Override
	public int getAvailableRows() {
		return dictionaryDao.getUserCount(namePattern);
	}

}
