package ru.ildar66.bm.common.searchfilter;

import java.util.Date;
import java.util.List;

import ru.ildar66.bm.common.entity.Currency;
import ru.ildar66.bm.common.instance.DealInstance;

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

	public boolean match(DealInstance inst) {
		// TODO Auto-generated method stub
		// if (!filter.getStatuses().contains(inst.getStatus())) {
		// return false;
		// }
		// if (filter.getDateFrom() != null && filter.getDateFrom().after(inst.getPlanExecutionDate())) {
		// return false;
		// }
		// if (filter.getDateTo() != null) {
		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(filter.getDateTo());
		// calendar.add(Calendar.DATE, 1);
		// if (!calendar.getTime().after(inst.getPlanExecutionDate())) {
		// return false;
		// }
		// }
		if (getCurrency() != null && getCurrency() != inst.getDeal().getCurrency()) {
			return false;
		}
		if (getAmountFrom() != null && getAmountFrom() > inst.getDeal().getAmount()) {
			return false;
		}
		if (getAmountTo() != null && getAmountTo() < inst.getDeal().getAmount()) {
			return false;
		}
		return true;
	}

}
