package ru.ildar66.bm.common.searchfilter;

import java.util.Date;
import java.util.List;

import ru.ildar66.bm.common.instance.DealInstance;

/**
 * Filter for list events for deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class EventsByDealFilter {
	public final String[] STATUSES = { "ALL CRF", "significant CRF", "nonessential CRF", "	Overdue KE" };
	
	private Date dateFrom;
	private Date dateTo;
	private List<String> selectedStatuses;

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public List<String> getSelectedStatuses() {
		return selectedStatuses;
	}

	public void setSelectedStatuses(List<String> selectedStatuses) {
		this.selectedStatuses = selectedStatuses;
	}

	public boolean match(DealInstance inst) {
		// TODO Auto-generated method stub
		return true;
	}

}
