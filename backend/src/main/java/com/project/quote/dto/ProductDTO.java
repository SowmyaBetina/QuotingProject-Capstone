package com.project.quote.dto;

public class ProductDTO {

	private String name;
    private String internalName;
    private String details;
    private Integer maxProductsPerLocation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInternalName() {
		return internalName;
	}
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getMaxProductsPerLocation() {
		return maxProductsPerLocation;
	}
	public void setMaxProductsPerLocation(Integer maxProductsPerLocation) {
		this.maxProductsPerLocation = maxProductsPerLocation;
	}
    

}
