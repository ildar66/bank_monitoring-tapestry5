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
	private Deal deal;
	private Contractor contractor;

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
}
