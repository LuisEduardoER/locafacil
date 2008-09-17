package com.locafacil.common;

public class CarCategory {
	private int categoryCode;
	private int categoryName;
	private RentType rentValue;
	/**
	 * @return the categoryCode
	 */
	public int getCategoryCode() {
		return categoryCode;
	}
	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * @return the categoryName
	 */
	public int getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(int categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the rentValue
	 */
	public RentType getRentValue() {
		return rentValue;
	}
	/**
	 * @param rentValue the rentValue to set
	 */
	public void setRentValue(RentType rentValue) {
		this.rentValue = rentValue;
	}
	public CarCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
}
