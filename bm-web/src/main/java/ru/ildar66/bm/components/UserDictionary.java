package ru.ildar66.bm.components;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import ru.ildar66.bm.common.entity.User;
import ru.ildar66.bm.dao.DictionaryDao;
import ru.ildar66.bm.model.UserDataSource;

//import org.apache.tapestry5.annotations.SessionState;

/**
 * Dictionary users.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class UserDictionary {
	// @Persist
	@Property
	private String userNamePattern;
	@Property
	private User user;

	@Inject
	// @SessionState
	private DictionaryDao dictionaryDao;
	@Inject
	private Messages messages;
	@Inject
	private BeanModelSource beanModelSource;
	@Inject
	private AjaxResponseRenderer ajaxResponseRenderer;

	@InjectComponent
	private Zone userGridZone;

	@OnEvent(value = EventConstants.SELECTED, component = "userSearchButton")
	void searchUsers() {
		ajaxResponseRenderer.addRender(userGridZone);
	}

	boolean onSelected(User selectedUser) {
		// bubbledUp to container
		userNamePattern = null;
		return false;
	}

	public GridDataSource getUsers() {
		return new UserDataSource(userNamePattern, dictionaryDao);
	}

	public BeanModel<User> getUserModel() {
		BeanModel<User> userModel = beanModelSource.createDisplayModel(User.class, messages);
		for (String prop : userModel.getPropertyNames()) {
			userModel.get(prop).sortable(false);
		}
		return userModel;
	}

}
