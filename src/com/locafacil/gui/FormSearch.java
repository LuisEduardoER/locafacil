package com.locafacil.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.portable.RemarshalException;

public class FormSearch extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private String formTitle;
	private String[] fields;
	private String[] cols;
	
	private JTextField txFilterValue;
	private JComboBox cbFilterField;
	private BasicPanel panelControls;
	private JPanel panelButtons;
	private JPanel panelHolder;
	private JScrollPane panelTable;
	public DefaultTableModel tableModel;
	private JTable formTable;
	
	private JButton btOpen;
	private JButton btEdit;
	private JButton btClose;
	private JButton btSearch;
	
		
	public FormSearch(String formTitle, String[] fields, String[] cols) {
		super();
		this.formTitle = formTitle;
		this.fields = fields;
		this.cols = cols;
		
		setFields(fields);
		setTitle(formTitle);
		setCols(cols);
		
		initializeForm();
		initializeControls();
		this.setSize(500,450);
		this.resizable = false;
		this.maximizable = false;
		
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
		DefaultComboBoxModel model = new DefaultComboBoxModel(getFields());
		getCbFilterField().setModel(model);
	}

	public String[] getCols() {
		return cols;
	}

	public void setCols(String[] cols) {
		this.cols = cols;
	}

	public FormSearch(){
		initializeForm();
		initializeControls();
		this.setSize(500,450);
		this.resizable = false;
		this.maximizable = false;
		
	}
	
	private void initializeForm(){
		this.setTitle("Pesquisa");		
		this.getContentPane().setLayout(new BorderLayout());
	}
	
	private void initializeHeaderControls(){
		btSearch = new JButton("Pesquisar");
		btSearch.addActionListener(this);
		GridBagLayout layout = new GridBagLayout();
	
		panelControls = new BasicPanel();
		txFilterValue = new JTextField();
		PanelHeader header = new PanelHeader(this.formTitle);
		
		panelControls.setLayout(layout);
		panelControls.add(header);
		panelControls.add("Valor para pesquisa",txFilterValue);
		panelControls.add("Campo para pesquisa", getCbFilterField());
		panelControls.add(btSearch);

	}
		
	private void initializeControls(){
		initializeHeaderControls();
		panelButtons = new JPanel();
		
		this.tableModel = new DefaultTableModel();
		for(int x =0; x<getCols().length; x++){
			this.tableModel.addColumn(getCols()[x]);
		}
		this.formTable = new JTable( this.tableModel );
		panelTable = new JScrollPane(formTable);
		
		
		panelHolder = new JPanel();
		panelHolder.setLayout(new GridLayout(1,2));
		//panelHolder.add(panelControls);
		panelHolder.add(panelTable);
		
		btOpen = new JButton("Novo");
		btOpen.addActionListener(this);
		btEdit = new JButton("Editar");
		btEdit.addActionListener(this);
		btClose = new JButton("Fechar");
		btClose.addActionListener(this);
		
		panelButtons.add(btOpen);
		panelButtons.add(btEdit);
		panelButtons.add(btClose);
		
		this.getContentPane().add(panelControls, BorderLayout.NORTH);
		this.getContentPane().add(panelHolder, BorderLayout.CENTER);
		this.getContentPane().add(panelButtons, BorderLayout.SOUTH);
	}

	public JComboBox getCbFilterField() {
		if(cbFilterField==null){
			cbFilterField = new JComboBox();
		}
		return cbFilterField;
	}

	public void setCbFilterField(JComboBox cbFilterField) {
		this.cbFilterField = cbFilterField;
	}

	private void actionBtOpen(){
		
	}
	
	private void actionBtEdit(){
		
	}
	
	private void actionBtClose(){
		
	}
	
	protected void actionBtPesquisar(){
		System.out.println("pai chamando");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(btOpen)){
			actionBtOpen();
		}
		if(arg0.getSource().equals(btEdit)){
			actionBtEdit();
		}
		if(arg0.getSource().equals(btClose)){
			actionBtClose();
		}
		
		if(arg0.getSource().equals(btSearch)){
			actionBtPesquisar();
		}
	}
	
	
	
}
