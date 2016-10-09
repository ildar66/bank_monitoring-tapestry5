package ru.ildar66.bm.common.entity;

/**
 * Deal entity.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class Deal {

	private Long amount;
	private Currency currency;
	private DealType type;
	private String contractNumber;

	public Deal(String contractNumber, Long amount, Currency currency, DealType type) {
		super();
		this.contractNumber = contractNumber;
		this.amount = amount;
		this.currency = currency;
		this.type = type;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public DealType getType() {
		return type;
	}

	public void setType(DealType type) {
		this.type = type;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
}
