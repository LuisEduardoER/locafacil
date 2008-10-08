package com.locafacil.gui;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.locafacil.Starter;
import com.locafacil.common.Car;
import com.locafacil.common.Client;
import com.locafacil.common.FieldType;

public class FormSearchCar extends FormSearch {
	public static FormCadastroCarro fm;
	
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
	
	public static FormCadastroCarro getFm(){
		if(fm==null){
			fm = new FormCadastroCarro();
			fm.setModal(true);
		}
		return fm;
	}
	
	/*MÉTODO QUE VERIFICAR SE FOI SELECIONADO ALGUM CLIENTE*/
	public int getLinhaSelecionada(){
		int result;
		result = (formTable.getSelectedRow() != -1) ? formTable.getSelectedRow() : -1;
		return result;
	}
	
	/*AÇÃO DO BOTÃO EDITAR EM BUSCAR CARROS*/
	protected void actionBtEdit(){
		getFm().estado = FormCadastro.EDITAR;
		try {
			if (getLinhaSelecionada() != -1){
				Car ca = (Car)FormSearch.vetor.elementAt(getLinhaSelecionada());
				getFm().setCar(ca);
				getFm().setVisible(true);
				actionBtPesquisar();	
				
			}else{
				JOptionPane.showMessageDialog(null, "Selecione um carro !");
			}
			
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("fudeu ");
			e.printStackTrace();
		}
	}
	
	
}
