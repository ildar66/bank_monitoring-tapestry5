package ru.ildar66.bm.components.event;

import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import ru.ildar66.bm.common.entity.EventType;
import ru.ildar66.bm.common.entity.EventTypeGroup;
import ru.ildar66.bm.common.entity.MonitoredObjectType;
import ru.ildar66.bm.common.instance.BmEvent;
import ru.ildar66.bm.dao.DictionaryDao;
import ru.ildar66.bm.services.impl.BaseEntityValueEncoder;

/**
 * Head event component.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class EventHead {

	@Parameter(required = true)
	@Property
	private BmEvent event;

	@Parameter(required = true)
	@Property
	private String mode;

	private List<MonitoredObjectType> monitoredObjectTypes;

	@Inject
	private SelectModelFactory selectModelFactory;
	@Inject
	private AjaxResponseRenderer ajaxResponseRenderer;
	@Inject
	private DictionaryDao dictionaryDao;

	@InjectComponent
	private Zone classifierSelectZone;

	@OnEvent(value = EventConstants.VALUE_CHANGED, component = "monitoredObjectTypeSelect")
	void selectMonitoredObjectType(MonitoredObjectType monitoredObjectType) {
		ajaxResponseRenderer.addRender(classifierSelectZone);
		event.getClassifier().setEventTypeGroup(null);
		event.getClassifier().setEventType(null);
	}

	@OnEvent(value = EventConstants.VALUE_CHANGED, component = "eventTypeGroupSelect")
	void selectEventTypeGroup(EventTypeGroup eventTypeGroup) {
		event.getClassifier().setEventType(null);
		ajaxResponseRenderer.addRender(classifierSelectZone);
	}

	public boolean isModeEdit() {
		return "EDIT".equalsIgnoreCase(mode);
	}

	public boolean isModeVIEW() {
		return "VIEW".equalsIgnoreCase(mode);
	}

	public boolean isModeADD() {
		return "ADD".equalsIgnoreCase(mode);
	}

	public SelectModel getMonitoredObjectTypeSelectModel() {
		return selectModelFactory.create(getMonitoredObjectTypes(), "name");
	}

	private List<MonitoredObjectType> getMonitoredObjectTypes() {
		if (monitoredObjectTypes == null) {
			monitoredObjectTypes = dictionaryDao.getMonitoredObjectTypes();
		}
		return monitoredObjectTypes;
	}

	public ValueEncoder<MonitoredObjectType> getMonitoredObjectTypeValueEncoder() {
		return new BaseEntityValueEncoder<MonitoredObjectType>(getMonitoredObjectTypes());
	}

	public SelectModel getEventTypeGroupSelectModel() {
		return selectModelFactory.create(getEventTypeGroups() != null ? getEventTypeGroups() : Collections.emptyList(),
				"name");
	}

	private List<EventTypeGroup> getEventTypeGroups() {
		List<EventTypeGroup> kmEventTypeGroups = null;
		if (event.getClassifier().getMonitoredObjectType() != null) {
			kmEventTypeGroups = dictionaryDao
					.getEventTypeGroups(event.getClassifier().getMonitoredObjectType().getId());
		}
		return kmEventTypeGroups;
	}

	public ValueEncoder<EventTypeGroup> getEventTypeGroupValueEncoder() {
		return new BaseEntityValueEncoder<EventTypeGroup>(getEventTypeGroups());
	}

	public SelectModel getEventTypeSelectModel() {
		return selectModelFactory.create(getEventTypes() != null ? getEventTypes() : Collections.emptyList(), "name");
	}

	private List<EventType> getEventTypes() {
		List<EventType> eventTypes = null;
		if (event.getClassifier().getEventTypeGroup() != null) {
			eventTypes = dictionaryDao.getEventTypes(event.getClassifier().getEventTypeGroup().getId());
		}
		return eventTypes;
	}

	public ValueEncoder<EventType> getEventTypeValueEncoder() {
		return new BaseEntityValueEncoder<EventType>(getEventTypes());
	}

}
