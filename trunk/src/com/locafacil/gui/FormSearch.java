package com.locafacil.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FormSearch extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lbFilterValue;
	private JTextField txFilterValue;
	private JLabel lbFilterField;
	private JComboBox cbFilterField;
	private JPanel panelControls;
	private JPanel panelButtons;
	private JPanel panelHolder;
	private JScrollPane panelTable;
	
	
	public FormSearch(){
		initializeForm();
		initializeControls();
	}
	
	private void initializeForm(){
		this.setTitle("Pesquisa");
		this.setSize(400,500);
		this.getContentPane().setLayout(new BorderLayout());
	}
	
	private void initializeControls(){
		panelControls = new JPanel();
		lbFilterValue = new JLabel("Pesquisar");
		txFilterValue = new JTextField();
		lbFilterField = new JLabel("Campo para pesquisa");
		cbFilterField = new JComboBox();
		panelControls.setLayout(null);
		panelControls.add(lbFilterValue);
		panelControls.add(txFilterValue);
		panelControls.add(lbFilterField);
		panelControls.add(cbFilterField);
		panelButtons = new JPanel();
		panelTable = new JScrollPane();
		panelTable.add(panelControls);
		panelHolder = new JPanel();
		panelHolder.setLayout(new GridLayout(1,2));
		panelHolder.add(panelControls);
		panelHolder.add(panelTable);
		
		
		this.getContentPane().add(panelHolder, BorderLayout.CENTER);
		this.getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}
	
}
