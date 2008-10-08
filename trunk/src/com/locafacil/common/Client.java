package com.locafacil.common;

import java.util.Date;

public class Client {
	private int code;
	private String name;
	private Address address;
	private String telephone;
	private String document;
	private String email;
	private String birthday;
	private int financialStatus;
	public static final int HAS_DEBIT = 1;
	public static final int NO_DEBIT = 0;
	
	
	public String[] getRowLine(){
		String[] row = new String[]{Integer.toString(getCode()),getName(),getTelephone()};
		return row;
	}
	
	public String toString(){
		return getName() + " | "+ getCode() + " | "+ getDocument() + " | "+ getEmail() + " | "+getFinancialStatus() + " | "+ getAddress().getCity() + " | "+ getAddress().getLongterm() + " | "+ getAddress().getState();
	}
	
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
	 * @return the document (CPF/CNPJ)
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}
	public Client() {
		super();
	}
	public Client(String email, String name, String telephone) {
		super();
		this.email = email;
		this.name = name;
		this.telephone = telephone;
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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the financialStatus
	 */
	public int getFinancialStatus() {
		return financialStatus;
	}
	/**
	 * @param financialStatus the financialStatus to set
	 */
	public void setFinancialStatus(int financialStatus) {
		this.financialStatus = financialStatus;
	}
}
