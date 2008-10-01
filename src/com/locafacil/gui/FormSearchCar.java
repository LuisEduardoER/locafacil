package com.locafacil.gui;

import java.util.Iterator;
import java.util.Vector;

import com.locafacil.Starter;
import com.locafacil.common.Car;
import com.locafacil.common.Client;

public class FormSearchCar extends FormSearch {
	static String formTitle = "Pesquisa de Carros";
	static String[] fields = {"Placa ", "Chassis", "Ano", "Modelo"}; // do combobox
	static String[] cols = {"Placa","Ano", "Chassis", " Modelo"}; // da tabela
	
	public FormSearchCar(){
		super(formTitle,fields,cols);
	}
	
	protected void actionBtPesquisar(){
		Vector<Car> rs = Starter.db.getCars();
		Iterator<Car> it = rs.iterator();
		while(it.hasNext()){
			tableModel.addRow(it.next().getRowLine());
		}
	}
	
	
}
