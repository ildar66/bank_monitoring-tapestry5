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

import ru.ildar66.bm.common.entity.Contractor;
import ru.ildar66.bm.dao.DictionaryDao;
import ru.ildar66.bm.model.ContractorsDataSource;

/**
 * Dictionary contractors.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class ContractorDictionary {
	//@Persist
	@Property
	private String contractorNamePattern;
	@Property
	private Contractor contractor;

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
	private Zone contractorGridZone;

	@OnEvent(value = EventConstants.SELECTED, component = "contractorSearchButton")
	void searchContractors() {
		ajaxResponseRenderer.addRender(contractorGridZone);
	}

	boolean onSelected(String id, String name) {
		// bubbledUp to container
		contractorNamePattern = null;
		return false;
	}

	public GridDataSource getContractors() {
		return new ContractorsDataSource(contractorNamePattern, dictionaryDao);
	}

	public BeanModel<Contractor> getContractorModel() {
		BeanModel<Contractor> contractorModel = beanModelSource.createDisplayModel(Contractor.class, messages);
		for (String prop : contractorModel.getPropertyNames()) {
			contractorModel.get(prop).sortable(false);
		}
		return contractorModel;
	}

}
