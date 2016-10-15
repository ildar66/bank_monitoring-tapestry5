package ru.ildar66.bm.model;

import java.util.List;

import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.dao.DictionaryDao;

/**
 * Clients DataSource.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class ClientDataSource implements GridDataSource {
	private int startIndex;
	private String clientNamePattern;
	private List<Client> clients;
	private DictionaryDao dictionaryDao;

	public ClientDataSource(String clientNamePattern, DictionaryDao dictionaryDao) {
		super();
		this.clientNamePattern = clientNamePattern;
		this.dictionaryDao = dictionaryDao;
	}

	// @Override
	public void prepare(int startIndex, int endIndex, List<SortConstraint> sortConstraints) {
		this.startIndex = startIndex;
		clients = dictionaryDao.getClients(startIndex, endIndex - startIndex + 1, clientNamePattern);
	}

	// @Override
	public Object getRowValue(int index) {
		return clients.get(index - startIndex);
	}

	// @Override
	public Class<Client> getRowType() {
		return Client.class;
	}

	// @Override
	public int getAvailableRows() {
		return dictionaryDao.getClientCount(clientNamePattern);
	}
}
