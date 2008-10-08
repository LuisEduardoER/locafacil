package com.locafacil.gui;

import java.awt.GridBagLayout;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.locafacil.Starter;
import com.locafacil.common.Address;
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
		Starter.db.addClient(generate());
	}

	public void handleUpdateClick(){
		if(estado == INSERIR_NOVO){
			Starter.db.updateClient(c, generate());
			handleCloseClick();
			JOptionPane.showMessageDialog(null, "Transação realizada com sucesso!");
		} else {
			handleAddClick();
		}
		
	}	
	
	private Client generate(){
		Client c = new Client();
		c.setName(getTxtNome().getText());
		c.setDocument(getTxtDocumento().getText());
		c.setEmail(getTxtEmail().getText());
		Address adr = new Address();
		adr.setCity(txtCidade.getText());
		adr.setLongterm(getTxtEndereco().getText());
		adr.setState(getTxtEstado().getText());
		c.setBirthday(getTxtData().getText());
		c.setTelephone(getTxtTelefone().getText());
		c.setAddress(adr);
		return c;
	}
	// DEPRECATED
	public Date getDate(String texto){
		Date dt = new Date();
		String[] campos = texto.split("/");
		dt.setMonth(1);
		dt.setYear(2);
		dt.setDate(0);
		return dt;
	}
	
	
	public void resetAllFields(){
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
		
			System.out.println(c);
			this.c = c;
			getTxtNome().setText(c.getName());
			getTxtEndereco().setText(c.getAddress().getLongterm());
			getTxtCidade().setText(c.getAddress().getCity());
			getTxtEstado().setText(c.getAddress().getState());
			getTxtEmail().setText(c.getEmail());
			getTxtDocumento().setText(c.getDocument());
			//getTxtData().setText(c.getBirthday().toString());
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
		//panelCampos.add("Data de Nascimento",txtData);


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
