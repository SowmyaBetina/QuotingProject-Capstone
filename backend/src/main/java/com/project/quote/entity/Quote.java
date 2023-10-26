package com.project.quote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quoteId;
    private String quoteName;
    private String quoteOwner;
	//private int qty;
	//private int unitprice;
	//private int total;
	
	public Long getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(Long quoteId) {
		this.quoteId = quoteId;
	}
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
    
    

}
