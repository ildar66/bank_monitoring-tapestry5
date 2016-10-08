package ru.ildar66.bm.common.searchfilter;

import java.util.Date;

/**
 * Filter for list events for deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class EventsByDealFilter {
	private Date dateFrom;
	private Date dateTo;

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

}
