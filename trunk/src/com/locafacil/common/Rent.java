package com.locafacil.common;



public class Rent {
	private String funcionario;
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	private int code;
	private String client;
	private String car;
	private int rentType;
	private String initialDate;
	private String endingDate;
	
	private int finalizado;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public int getRentType() {
		return rentType;
	}
	public void setRentType(int rentType) {
		this.rentType = rentType;
	}
	public String getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}
	public String getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	public void setFinalizado(int finalizado) {
		this.finalizado = finalizado;
	}
	public int getFinalizado() {
		return finalizado;
	}
	private String additionalInformation;
	
	public String[] getRowLine(){
		String[] row = new String[]{getClient(),getCar(),getEndingDate()};
		return row;
	}
	
}
