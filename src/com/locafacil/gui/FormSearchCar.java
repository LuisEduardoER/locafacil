package com.locafacil.gui;

import java.util.Iterator;
import java.util.Vector;

import com.locafacil.Starter;
import com.locafacil.common.Car;
import com.locafacil.common.Client;
import com.locafacil.common.FieldType;

public class FormSearchCar extends FormSearch {
	static String formTitle = "Pesquisa de Carros";
	static String[] fieldsDef = {"vc_placa", "vc_chassi", "in_ano","in_cod_modelo"};
	static String[] fields = {"Placa ", "Chassis", "Ano", "Modelo"}; // do combobox
	static String[] cols = {"Placa","Ano", "Chassis", " Modelo"}; // da tabela
	static int[] tipos = {FieldType.STRING, FieldType.STRING, FieldType.INT, FieldType.INT};
	
	public FormSearchCar(){
		super(formTitle,fields,cols,tipos);
	}
	
	protected void actionBtPesquisar(){
		Vector<Car> rs = Starter.db.getCars();
		Iterator<Car> it = rs.iterator();
		while(it.hasNext()){
			tableModel.addRow(it.next().getRowLine());
		}
	}
	
	
}
