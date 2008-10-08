package com.locafacil.gui;

import javax.swing.JTextField;

import com.locafacil.common.Car;
import com.locafacil.common.Client;


import java.awt.GridBagLayout;

public class FormCadastroCarro extends FormCadastro {
		

	private JTextField txtCategoria;
	private JTextField txtChassis;
	private JTextField txtPlaca;
	private JTextField txtConstrutor;
	private JTextField txtNome;
	private JTextField txtModelo;
	private JTextField txtAno;
	
	private Car ca;


	public FormCadastroCarro(){
		
		panelCampos.setLayout(new GridBagLayout());
		
		txtCategoria = new JTextField();
		txtChassis = new JTextField();
		txtPlaca= new JTextField();
		txtConstrutor = new JTextField();
		txtNome= new JTextField ();
		txtModelo = new JTextField ();
		txtAno = new JTextField ();
	
		
		panelCampos.add("Categoria",txtCategoria);
		panelCampos.add("Chassis",txtChassis);
		panelCampos.add("Placa", txtPlaca);
		panelCampos.add("Construtor", txtConstrutor);
		panelCampos.add("Nome",txtNome);
		panelCampos.add("Modelo", txtModelo);
		panelCampos.add("Ano", txtAno);
		
	}
	
	public JTextField getTxtCategoria() {
		return txtCategoria;
	}
	
	public JTextField getTxtChassis() {
		return txtChassis;
	}
	
	public JTextField getTxtPlaca() {
		return txtPlaca;
	}
	
	public JTextField getTxtConstrutor() {
		return txtConstrutor;
	}
	
	public JTextField getTxtNome() {
		return txtNome;
	}
	
	public JTextField getTxtModelo() {
		return txtModelo;
	}
	
	public JTextField getTxtAno() {
		return txtAno;
	}
	
	public void setCar(Car ca){
		
		System.out.println(ca);
		this.ca = ca;
		
		getTxtCategoria().setText(ca.getCategory().toString());
		getTxtChassis().setText(ca.getChassis());
		getTxtPlaca().setText(ca.getPlaca());
		getTxtConstrutor().setText(ca.getConstructor());
		getTxtNome().setText(ca.getName());
		getTxtModelo().setText(ca.getModel());
		getTxtAno().setText(Integer.toString(ca.getYear()));
	}
	
}



