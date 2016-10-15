package ru.ildar66.bm.common.instance;

import ru.ildar66.bm.common.entity.Client;
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
	private Client client;
	private String status = EVENT_STATUS_NEW;

	public DealEvent(Deal deal, Client client) {
		super();
		this.deal = deal;
		this.client = client;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
