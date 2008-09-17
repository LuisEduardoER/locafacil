package com.locafacil.common;

public class Car {
	private int code;
	private CarCategory category;
	private String chassis;
	private String placa;
	private String constructor;
	private String name;
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the category
	 */
	public CarCategory getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(CarCategory category) {
		this.category = category;
	}
	/**
	 * @return the chassis
	 */
	public String getChassis() {
		return chassis;
	}
	/**
	 * @param chassis the chassis to set
	 */
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return the constructor
	 */
	public String getConstructor() {
		return constructor;
	}
	/**
	 * @param constructor the constructor to set
	 */
	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String model;
	private int year;
	
}
