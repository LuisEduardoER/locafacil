package com.locafacil.gui;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

public class FormCadastroClient extends FormCadastro {
	
	private JTextField txNome;
	private JTextField txEndereco;
	
	public FormCadastroClient(){
		panelCampos.setLayout(new GridBagLayout());
		txNome = new JTextField();
		txEndereco = new JTextField();
		panelCampos.add("Nome",txNome);
		panelCampos.add("Endereço",txEndereco);
		
	}
}
