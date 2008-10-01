package com.locafacil.gui;

import java.awt.GridBagLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.locafacil.Starter;
import com.locafacil.common.Client;

public class FormCadastroClient extends FormCadastro {
	
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtDocumento;
	private JTextField txtData;
	
	private Client c;
	
	
//public BasicPanel panelCampos;

	public void handleAddClick(){
		Starter.db.addClient(c);
	}
	
	private void updateGrid(){
		
	}
	
	private Client generate(){
		Client c = new Client();
		c.setName(getTxtNome().getText());
		return c;
	}
	
	public void handleDeleteClick(){
		
		if(JOptionPane.showConfirmDialog(this,"Tem Certeza", "Aplicação", 
		JOptionPane.OK_CANCEL_OPTION, 
		JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION){
			com.locafacil.Starter.db.deleteClientByCode(c.getCode());
			resetAllFields();
			JOptionPane.showMessageDialog(null,"Cliente Apagado");
		}
		
	}
	
	private void resetAllFields(){
		getTxtNome().setText("");
		getTxtEndereco().setText("");
		getTxtCidade().setText("");
		getTxtEstado().setText("");
		getTxtEmail().setText("");
		getTxtDocumento().setText("");
		getTxtData().setText("");
		getTxtTelefone().setText("");
	}
	
	public void setClient(Client c){
		this.c = c;
		getTxtNome().setText(c.getName());
		getTxtEndereco().setText(c.getAddress().getLongterm());
		getTxtCidade().setText(c.getAddress().getCity());
		getTxtEstado().setText(c.getAddress().getState());
		getTxtEmail().setText(c.getEmail());
		getTxtDocumento().setText(c.getDocument());
		getTxtData().setText(c.getBirthday().toString());
		getTxtTelefone().setText(c.getTelephone());
	}
	
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
		panelCampos.add("Endereço",txtEndereco);
		panelCampos.add("Cidade", txtCidade);
		panelCampos.add("Estado", txtEstado);
		panelCampos.add("Email",txtEmail);
		panelCampos.add("Telefone", txtTelefone);
		panelCampos.add("CPF/CNPJ", txtDocumento);
		panelCampos.add("Data de Nascimento",txtData);


	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public JTextField getTxtEstado() {
		return txtEstado;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public JTextField getTxtData() {
		return txtData;
	}
}
