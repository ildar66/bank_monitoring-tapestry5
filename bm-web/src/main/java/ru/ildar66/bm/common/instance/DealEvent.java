package ru.ildar66.bm.common.instance;

import java.util.ArrayList;
import java.util.List;

import ru.ildar66.bm.common.entity.Client;
import ru.ildar66.bm.common.entity.Deal;
import ru.ildar66.bm.common.entity.NotificationRecipient;

/**
 * event for Deals.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class DealEvent {
	private final static String EVENT_STATUS_NEW = "NEW";

	private Long id;
	private String name;
	private Deal deal;
	private Client client;
	private String status = EVENT_STATUS_NEW;
	private List<NotificationRecipient> recipients = new ArrayList<NotificationRecipient>();

	public DealEvent(Deal deal, Client client) {
		super();
		this.deal = deal;
		this.client = client;
	}

	public DealEvent() {
		super();
	}

	public List<NotificationRecipient> getRecipients() {
		return recipients;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
