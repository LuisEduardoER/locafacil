package com.locafacil.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.locafacil.Starter;
import com.locafacil.common.Client;
import com.locafacil.common.FieldType;
import com.locafacil.common.Rent;

public class FormAluguel extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	static String[] fieldsDef = {"lorem","cli.vc_nome", "car.vc_nome", "data_prevista"};
	public static String[] cols = {"Cliente", "Carro", "Previsao de Entrega"};
	public static String[] fields = {"Todos","Cliente", "Carro", "Previsao de Entrega"};
	static int[] tipos = {FieldType.STRING, FieldType.STRING, FieldType.STRING};
	private static final long serialVersionUID = 3052481095992119594L;
	public PanelHeader header;
	private JButton btDelete;
	private JButton btInsert;
	private JButton btClose;
	private JButton btPesquisar;
	private JPanel panelButtons;
	
	private JComboBox  cbCampos;
	private JTextField  txtPesquisa;
	
	public BasicPanel panelCampos;
	
	public DefaultTableModel tableModel;
	public JTable formTable;
	private JScrollPane panelTable;
	private JPanel panelHolder;
	
	private FormCadastroAluguel fm;
	
	public FormAluguel(){
		initializeForm();
		initializeControls();
		setupLayout();
		setupFields();
		setupCombo();
		actionPesquisar();
	}
	
	private void setupCombo(){
		//cbCampos.setModel(Starter.db.getComboData("lf_cad_funcionario", "vc_nome"));
	}
	
	private void setupFields(){
		this.tableModel = new DefaultTableModel();
		for(int x =0; x<cols.length; x++){
			this.tableModel.addColumn(cols[x]);
		}
		this.formTable = new JTable(this.tableModel );
		panelTable = new JScrollPane(formTable);
		panelHolder.add(panelTable);
		panelCampos.setLayout(new GridBagLayout());
		txtPesquisa = new JTextField();
		cbCampos = new JComboBox();
		
		DefaultComboBoxModel model = new DefaultComboBoxModel(FormAluguel.fields);
		cbCampos.setModel(model);
		
		panelCampos.add(header);
		panelCampos.add("Pesquisar", txtPesquisa);
		panelCampos.add("Dados",cbCampos);
		btPesquisar = new JButton("Pesquisar");
		btPesquisar.addActionListener(this);
		panelCampos.add(btPesquisar);
		
	}
	
	
	
	private void setupLayout() {
		// TODO Auto-generated method stub
		this.add(panelCampos,BorderLayout.NORTH);
		this.add(panelHolder, BorderLayout.CENTER);
		this.add(panelButtons, BorderLayout.SOUTH);
	}



	private void initializeControls() {
		
		header = new PanelHeader("Aluguel");
		btClose = new JButton("Fechar");
		btClose.addActionListener(this);
		btDelete = new JButton("Baixa de Aluguel");
		btDelete.addActionListener(this);
		btInsert = new JButton("Registrar Aluguel");
		btInsert.addActionListener(this);
		panelCampos = new BasicPanel();
		panelButtons = new JPanel();
		panelButtons.add(btClose);
		panelButtons.add(btDelete);
		panelButtons.add(btInsert);
		
		
//		this.formTable = new JTable( this.tableModel );
//		panelTable = new JScrollPane();
		
		
		panelHolder = new JPanel();
		panelHolder.setLayout(new GridLayout(1,2));
		//panelHolder.add(panelControls);
//		panelHolder.add(panelTable);
	}

	private void initializeForm(){
		this.setTitle("Novo Aluguel");
		this.setSize(550,450);
		this.setLayout(new BorderLayout());
	}

	public void handleAddClick(){
		getFm().setModal(true);
		getFm().refresh();
		getFm().setVisible(true);
	}

	public void handleDeleteClick(){
		
	}
	
	public void handleCloseClick(){
		this.dispose();
	}
	
	public void limparGrid(){
		while(tableModel.getRowCount()>0){
			tableModel.removeRow(0);
		}
		
	}
	
	public void actionPesquisar(){
		Vector<Rent> vetor;
		if(cbCampos.getSelectedIndex()!=0){
			String campo = cbCampos.getModel().getSelectedItem().toString();
			int index = cbCampos.getSelectedIndex();
			int tipo = tipos[index];
			vetor = Starter.db.searchAluguel(getField(index), this.txtPesquisa.getText());	
		} else {
			vetor = Starter.db.getAlugueis();
		}
		
		Iterator<Rent> it = vetor.iterator();
		limparGrid();
		while(it.hasNext()){
			tableModel.addRow(it.next().getRowLine());
		}
	}
	
	public FormCadastroAluguel getFm() {
		if(fm==null){
			fm = new FormCadastroAluguel();
		}
		return fm;
	}

	public void setFm(FormCadastroAluguel fm) {
		this.fm = fm;
	}

	private String getField(int index) {
		// TODO Auto-generated method stub
		return fieldsDef[index];
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(this.btInsert)){
			handleAddClick();
		}
		if(arg0.getSource().equals(this.btDelete)){
			handleDeleteClick();
		}
		if(arg0.getSource().equals(this.btClose)){
			handleCloseClick();
		}
		if(arg0.getSource().equals(this.btPesquisar)){
			actionPesquisar();
		}
	}
	
}
