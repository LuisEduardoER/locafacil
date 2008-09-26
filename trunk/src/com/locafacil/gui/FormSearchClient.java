package com.locafacil.gui;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.TableModel;

import com.locafacil.Starter;
import com.locafacil.common.Client;
public class FormSearchClient extends FormSearch {

	
	
	private static final long serialVersionUID = 1L;
	
	public FormSearchClient(String formTitle, String[] fields, String[] cols){
		super(formTitle,fields,cols);

	}
	
	@SuppressWarnings("unused")
	protected void actionBtPesquisar(){
		Vector<Client> rs = Starter.db.getClients();
		Iterator<Client> it = rs.iterator();
		while(it.hasNext()){
			tableModel.addRow(it.next().getRowLine());
		}
	}

}
