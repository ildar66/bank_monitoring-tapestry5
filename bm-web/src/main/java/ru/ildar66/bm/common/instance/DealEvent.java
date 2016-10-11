package ru.ildar66.bm.common.instance;

import ru.ildar66.bm.common.entity.Contractor;
import ru.ildar66.bm.common.entity.Deal;

/**
 * event for Deals.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealEvent {
	private final static String EVENT_STATUS_NEW = "NEW";
	
	private long id;
	private Deal deal;
	private Contractor contractor;
	private String status = EVENT_STATUS_NEW;

	public DealEvent(Deal deal, Contractor contractor) {
		super();
		this.deal = deal;
		this.contractor = contractor;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
