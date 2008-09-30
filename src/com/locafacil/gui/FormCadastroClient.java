package com.locafacil.gui;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

public class FormCadastroClient extends FormCadastro {
	
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtDocumento;
	private JTextField txtData;
	
	
//public BasicPanel panelCampos;
	
	
	public FormCadastroClient(){
		panelCampos.setLayout(new GridBagLayout());
		txtNome = new JTextField();
		txtEndereco = new JTextField();
		txtCidade = new JTextField();
		txtEstado = new JTextField();
		txtEmail = new JTextField ();
		txtDocumento = new JTextField ();
		txtData = new JTextField ();
		txtTelefone = new JTextField();
		
		panelCampos.add("Nome",txtNome);
		panelCampos.add("Endere�o",txtEndereco);
		panelCampos.add("Cidade", txtCidade);
		panelCampos.add("Estado", txtEstado);
		panelCampos.add("Email",txtEmail);
		panelCampos.add("Telefone", txtTelefone);
		panelCampos.add("CPF/CNPJ", txtDocumento);
		panelCampos.add("Data de Nascimento",txtData);


	}
}