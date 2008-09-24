package com.locafacil.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
	private DefaultTableModel tableModel;
	private JTable formTable;
	
	private JButton btOpen;
	private JButton btEdit;
	private JButton btClose;
	
	public FormSearch(){
		initializeForm();
		initializeControls();
		this.setSize(500,450);
	}
	
	private void initializeForm(){
		this.setTitle("Pesquisa");		
		this.getContentPane().setLayout(new BorderLayout());
	}
	
	private void initializeControls(){
		panelControls = new JPanel();
		lbFilterValue = new JLabel("Pesquisar");
		txFilterValue = new JTextField();
		lbFilterField = new JLabel("Campo para pesquisa");
		cbFilterField = new JComboBox();
		
		panelControls.setLayout(new GridLayout(3,2));
		panelControls.add(lbFilterValue);
		panelControls.add(txFilterValue);
		panelControls.add(lbFilterField);
		panelControls.add(cbFilterField);
		panelButtons = new JPanel();
		
		this.tableModel = new DefaultTableModel();
		this.tableModel.addColumn("a");
		this.tableModel.addColumn("b");
		this.tableModel.addColumn("c");
		this.formTable = new JTable( this.tableModel );
		panelTable = new JScrollPane(formTable);
		
		
		panelHolder = new JPanel();
		panelHolder.setLayout(new GridLayout(1,2));
		//panelHolder.add(panelControls);
		panelHolder.add(panelTable);
		
		btOpen = new JButton("Novo");
		btEdit = new JButton("Editar");
		btClose = new JButton("Fechar");
		
		panelButtons.add(btOpen);
		panelButtons.add(btEdit);
		panelButtons.add(btClose);
		
		this.getContentPane().add(panelControls, BorderLayout.NORTH);
		this.getContentPane().add(panelHolder, BorderLayout.CENTER);
		this.getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}
	
}
