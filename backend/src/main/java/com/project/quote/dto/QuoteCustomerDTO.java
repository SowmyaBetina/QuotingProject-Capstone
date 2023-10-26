package com.project.quote.dto;


public class QuoteCustomerDTO {
    private String quoteName;
    private String quoteOwner;
    private String customerName;
    private String accountStatus;
	
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	private int unitprice;
	private int total;
	public String getQuoteName() {
		return quoteName;
	}
	public void setQuoteName(String quoteName) {
		this.quoteName = quoteName;
	}
	public String getQuoteOwner() {
		return quoteOwner;
	}
	public void setQuoteOwner(String quoteOwner) {
		this.quoteOwner = quoteOwner;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
    

}
