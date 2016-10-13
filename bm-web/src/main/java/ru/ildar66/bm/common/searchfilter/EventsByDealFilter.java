package ru.ildar66.bm.common.searchfilter;

import java.util.Date;
import java.util.List;

import ru.ildar66.bm.common.entity.Currency;
import ru.ildar66.bm.common.instance.DealEvent;

/**
 * Filter for list events for deal
 * 
 * @author Shafigullin Ildar
 * 
 */
public class EventsByDealFilter {
	public final String[] STATUSES = { "ALL CRF", "significant CRF", "nonessential CRF", "Overdue KE" };

	private Date dateFrom;
	private Date dateTo;
	private List<String> selectedStatuses;

	private Long amountFrom;
	private Long amountTo;
	private Currency currency;

	public Long getAmountFrom() {
		return amountFrom;
	}

	public void setAmountFrom(Long amountFrom) {
		this.amountFrom = amountFrom;
	}

	public Long getAmountTo() {
		return amountTo;
	}

	public void setAmountTo(Long amountTo) {
		this.amountTo = amountTo;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

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

	public boolean match(DealEvent event) {
		if (getSelectedStatuses() != null && getSelectedStatuses().size() > 0
				&& !getSelectedStatuses().contains(event.getStatus())) {
			return false;
		}
		if (getDateFrom() != null && getDateFrom().after(event.getDeal().getDate())) {
			return false;
		}
		if (getDateTo() != null) {
			Date dateTo = new Date(getDateTo().getTime() + 24 * 60 * 60 * 1000);
			if (dateTo.before(event.getDeal().getDate())) {
				return false;
			}
		}

		if (getCurrency() != null && getCurrency() != event.getDeal().getCurrency()) {
			return false;
		}
		if (getAmountFrom() != null && getAmountFrom() > event.getDeal().getAmount()) {
			return false;
		}
		if (getAmountTo() != null && getAmountTo() < event.getDeal().getAmount()) {
			return false;
		}
		return true;
	}
	
	public boolean isValid(){
		if(dateFrom != null && dateTo != null && dateTo.before(dateFrom)){
			return false;
		}		
		return true;
	}
}
