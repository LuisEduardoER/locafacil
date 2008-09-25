package com.locafacil.common;

public class Address {
	// logradouro
	private String longterm;
	private String compl;
	private String city;
	private String state;
	//cep
	private String postal;
	public Address() {
		super();
	}
	public Address(String city, String compl, String longterm, String postal,
			String state) {
		super();
		this.city = city;
		this.compl = compl;
		this.longterm = longterm;
		this.postal = postal;
		this.state = state;
	}
	/**
	 * @return the longterm
	 */
	public String getLongterm() {
		return longterm;
	}
	/**
	 * @param longterm the longterm to set
	 */
	public void setLongterm(String longterm) {
		this.longterm = longterm;
	}
	/**
	 * @return the compl
	 */
	public String getCompl() {
		return compl;
	}
	/**
	 * @param compl the compl to set
	 */
	public void setCompl(String compl) {
		this.compl = compl;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the postal
	 */
	public String getPostal() {
		return postal;
	}
	/**
	 * @param postal the postal to set
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}
}
