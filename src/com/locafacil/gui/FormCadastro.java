package com.locafacil.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormCadastro extends JDialog implements ActionListener{
	public PanelHeader header;
	private JButton btConfirm;
	private JButton btDelete;
	private JButton btInsert;
	private JButton btClose;
	private JPanel panelButtons;
	
	public static int INSERIR_NOVO = 0;
	public static int EDITAR = 1;
	
	public int estado = INSERIR_NOVO;
	
	
	public BasicPanel panelCampos;
	
	public FormCadastro(){
		initializeForm();
		initializeControls();
		setupLayout();
	}

	
	
	private void setupLayout() {
		// TODO Auto-generated method stub
		this.add(header,BorderLayout.NORTH);
		this.add(panelCampos, BorderLayout.CENTER);
		this.add(panelButtons, BorderLayout.SOUTH);
	}



	private void initializeControls() {
		header = new PanelHeader("Cadastro");
		btClose = new JButton("Fechar");
		btClose.addActionListener(this);
		btConfirm = new JButton("Confirmar");
		btConfirm.addActionListener(this);
		btDelete = new JButton("Remover");
		btDelete.addActionListener(this);
		//btInsert = new JButton("Adicionar Novo");
		//btInsert.addActionListener(this);
		panelCampos = new BasicPanel();
		panelButtons = new JPanel();
		panelButtons.add(btClose);
		panelButtons.add(btConfirm);
		//panelButtons.add(btDelete);
		//panelButtons.add(btInsert);
	}

	private void initializeForm(){
		this.setTitle("Cadastro");
		this.setSize(550,450);
		this.setLayout(new BorderLayout());
	}

	public void handleAddClick(){
		
	}

	public void handleDeleteClick(){
		
	}
	
	public void handleUpdateClick(){

	}
	
	public void handleCloseClick(){
		this.dispose();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(this.btInsert)){
			handleAddClick();
		}
		if(arg0.getSource().equals(this.btDelete)){
			handleDeleteClick();
		}
		if(arg0.getSource().equals(this.btConfirm)){
			handleUpdateClick();
		}
		if(arg0.getSource().equals(this.btClose)){
			handleCloseClick();
		}
	}
	

}
