package com.locafacil.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormCadastro extends JFrame {
	public PanelHeader header;
	private JButton btConfirm;
	private JButton btDelete;
	private JButton btInsert;
	private JButton btClose;
	private JPanel panelButtons;
	
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
		btConfirm = new JButton("Confirmar");
		btDelete = new JButton("Remover");
		btInsert = new JButton("Adicionar Novo");
		panelCampos = new BasicPanel();
		panelButtons = new JPanel();
		panelButtons.add(btClose);
		panelButtons.add(btConfirm);
		panelButtons.add(btDelete);
		panelButtons.add(btInsert);
	}

	private void initializeForm(){
		this.setTitle("Cadastro");
		this.setSize(550,450);
		this.setLayout(new BorderLayout());
	}
	

}
