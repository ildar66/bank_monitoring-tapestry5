package ru.ildar66.bm.components.event;

import java.util.List;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

import ru.ildar66.bm.common.entity.EType;
import ru.ildar66.bm.common.entity.EventGroup;
import ru.ildar66.bm.common.entity.MonitoredObject;

/**
 * Event type select component.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class EventTypeSelect {
	@Persist
	@Property
	private MonitoredObject monitoredObject;

	@Persist
	@Property
	private EventGroup eventGroup;

	@Persist
	@Property
	private EType eventType;

	@InjectComponent
	private Zone groupTypeZone;

	public List<EventGroup> getEventGroupModel() {
		return EventGroup.getSubGroup(monitoredObject);
	}

	public List<EType> getEventTypeModel() {
		return EType.getSybTypes(eventGroup);
	}

	public Object onValueChangedFromMonitoredObject(MonitoredObject mo) {
		eventGroup = null;
		eventType = null;
		return groupTypeZone.getBody();
	}

	public Object onValueChangedFromEventGroup(EventGroup eg) {
		eventType = null;
		return groupTypeZone.getBody();
	}
	
	public boolean onValueChangedFromEventType(EType et) {
		return false;
	}

}
