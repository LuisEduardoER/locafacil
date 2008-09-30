package com.locafacil.gui;

import javax.swing.JTextField;


import java.awt.GridBagLayout;

public class FormCadastroCarro extends FormCadastro {
		

	private JTextField txtCategoria;
	private JTextField txtChassis;
	private JTextField txtPlaca;
	private JTextField txtConstrutor;
	private JTextField txtNome;
	private JTextField txtModelo;
	private JTextField txtAno;


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
}



