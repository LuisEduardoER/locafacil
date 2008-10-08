package com.locafacil.gui;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.locafacil.Starter;
import com.locafacil.common.Client;
import com.locafacil.common.FieldType;
public class FormSearchClient extends FormSearch {
	public static FormCadastroClient fm;
	static String formTitle = "Pesquisa de Clientes";
	static String[] fieldsDef = {"vc_nome", "in_cod_cliente", "vc_telefone","in_cod_cidade"};
	static String[] fields = {"Nome", "Codigo", "Telefone","Cidade"};
	static String[] cols = {"Codigo","Nome", "Telefone"};
	static int[] tipos = {FieldType.STRING, FieldType.INT, FieldType.STRING, FieldType.STRING};
	
	private static final long serialVersionUID = 1L;
	
	public FormSearchClient(){
		super(formTitle,fields,cols,tipos);
		getAllClients();
		//this.formTable.selectAll();
		
	}
	
	protected void actionBtEdit(){
		getFm().estado = FormCadastro.EDITAR;
		try {
			Client c = (Client)FormSearch.vetor.elementAt(getLinhaSelecionada());
//		/System.out.println(c.getName());
			getFm().setClient(c);
			getFm().setVisible(true);
			actionBtPesquisar();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("fudeu ");
			e.printStackTrace();
		}
	}
	

	public int getLinhaSelecionada(){
		int result;
		result = (formTable.getSelectedRow() != -1) ? formTable.getSelectedRow() : 0;
		return result;
	}
	
	protected void actionBtOpen(){
		getFm().estado = FormCadastro.INSERIR_NOVO;
		getFm().resetAllFields();
		getFm().setVisible(true);
	}
	
	protected void getAllClients(){
		Vector<Client> rs = Starter.db.getClients();
		FormSearch.vetor = rs;
		Iterator<Client> it = rs.iterator();
		limparGrid();
		while(it.hasNext()){
			tableModel.addRow(it.next().getRowLine());
		}
	}
	
	public String getField(int index){
		return fieldsDef[index];
	}

	protected void actionBtDelete(){
		Client c = (Client)FormSearch.vetor.elementAt(getLinhaSelecionada());
		if(JOptionPane.showConfirmDialog(this,"Tem Certeza", "Aplica��o", 
		JOptionPane.OK_CANCEL_OPTION, 
		JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION){
			com.locafacil.Starter.db.deleteClientByCode(c.getCode());
			JOptionPane.showMessageDialog(null,"Cliente Apagado");
		}
		getAllClients();
	}
	
	protected void actionBtPesquisar(){
		String campo = getCbFilterField().getModel().getSelectedItem().toString();
		int index = getCbFilterField().getSelectedIndex();
		int tipo = tipos[index];
		Vector<Client> vetor = Starter.db.searchClient(tipo, getField(index), this.txFilterValue.getText());
		Iterator<Client> it = vetor.iterator();
		limparGrid();
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
