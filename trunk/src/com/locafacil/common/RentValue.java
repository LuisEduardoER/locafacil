package com.locafacil.common;

public class RentValue {
	/*
	 * Essa classe tem como objetivo criar os pacotes de alugueis
	 * onde sera possivel determinar as opcoes, incluindo quantidade de dias ou kilometros de franquia 
	 * a implementar -> valor de multa diaria/por quilometro sobre as entregas atrasadas
	 * 
	 */
	public final static int FREE_KILOMETERS = 0;
	// constante statica utilizada pra determinar quando a kilometragem sera livre ou nao
	private int days;
	private double rentValue;
	private int kilometers;
	private String description;
	public final static int NO_SECURE = 1;
	public final static int PARTIAL_SECURE = 2;
	public final static int FULL_SECURE = 3;
	
	public RentValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}
	/**
	 * @param days the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}
	/**
	 * @return the rentValue
	 */
	public double getRentValue() {
		return rentValue;
	}
	/**
	 * @param rentValue the rentValue to set
	 */
	public void setRentValue(double rentValue) {
		this.rentValue = rentValue;
	}
	/**
	 * @return the kilometers
	 */
	public int getKilometers() {
		return kilometers;
	}
	/**
	 * @param kilometers the kilometers to set
	 */
	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
