package ru.ildar66.bm.components;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.dao.DictionaryDao;
import ru.ildar66.bm.model.ClientDataSource;

/**
 * Dictionary clients.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class ClientDictionary {
	public final static String ALL_CLIENTS_PATTERN = "*";

	// @Persist
	@Property
	private String clientNamePattern = ALL_CLIENTS_PATTERN;
	@Property
	private Client client;

	// @Inject
	@SessionState
	private DictionaryDao dictionaryDao;
	@Inject
	private Messages messages;
	@Inject
	private BeanModelSource beanModelSource;
	@Inject
	private AjaxResponseRenderer ajaxResponseRenderer;

	@InjectComponent
	private Zone clientGridZone;

	@OnEvent(value = EventConstants.SELECTED, component = "clientSearchButton")
	void searchClients() {
		ajaxResponseRenderer.addRender(clientGridZone);
	}

	boolean onSelected(String id, String name) {
		// bubbledUp to container
		clientNamePattern = null;
		return false;
	}

	public GridDataSource getClients() {
		return new ClientDataSource(clientNamePattern, dictionaryDao);
	}

	public BeanModel<Client> getClientModel() {
		BeanModel<Client> clientModel = beanModelSource.createDisplayModel(Client.class, messages);
		for (String prop : clientModel.getPropertyNames()) {
			clientModel.get(prop).sortable(false);
		}
		return clientModel;
	}

}
