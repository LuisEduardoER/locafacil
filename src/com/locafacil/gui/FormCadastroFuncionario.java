package com.locafacil.gui;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

public class FormCadastroFuncionario extends FormCadastro {

	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEstado;	
	private JTextField txtTelefone;	
	private JTextField txtData;
	private JTextField txtLogin;
	private JTextField txtSenha;
	
	
	
	 public FormCadastroFuncionario() {
		

		panelCampos.setLayout(new GridBagLayout());
		
		txtNome = new JTextField();
		txtEndereco = new JTextField();
		txtCidade = new JTextField();
		txtEstado = new JTextField();
		txtData = new JTextField ();
		txtTelefone = new JTextField();
		txtLogin = new JTextField ();
		txtSenha = new JTextField ();
		
		panelCampos.add("Nome",txtNome);
		panelCampos.add("Endereço",txtEndereco);
		panelCampos.add("Cidade", txtCidade);
		panelCampos.add("Estado", txtEstado);		
		panelCampos.add("Telefone", txtTelefone);		
		panelCampos.add("Data de Nascimento",txtData);
		panelCampos.add("Login", txtLogin);
		panelCampos.add("Senha", txtSenha);
		
		}

	}

	

