package com.locafacil.gui;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.locafacil.Starter;
import com.locafacil.common.Client;
public class FormSearchClient extends FormSearch {
	public static FormCadastroClient fm;
	static String formTitle = "Pesquisa de Clientes";
	static String[] fields = {"Nome", "Codigo", "Telefone","Cidade"};
	static String[] cols = {"Codigo","Nome", "Telefone"};
	
	private static final long serialVersionUID = 1L;
	
	public FormSearchClient(){
		super(formTitle,fields,cols);
		
		
	}
	
	protected void actionBtEdit(){
		System.out.println(formTable.getSelectedRow());
		Client c = (Client)FormSearch.vetor.elementAt(formTable.getSelectedRow());
		System.out.println(c.getName());
		getFm().setClient(c);
		getFm().setVisible(true);
	}
	
	protected void actionBtPesquisar(){
		Vector<Client> rs = Starter.db.getClients();
		FormSearch.vetor = rs;
		Iterator<Client> it = rs.iterator();
		while(it.hasNext()){
			tableModel.addRow(it.next().getRowLine());
		}
	}

	public static FormCadastroClient getFm() {
		if(fm==null){
			fm = new FormCadastroClient();
			fm.setModal(true);
		}
		return fm;
	}

}
