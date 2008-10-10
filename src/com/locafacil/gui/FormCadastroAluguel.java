package com.locafacil.gui;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.locafacil.Starter;
import com.locafacil.common.Rent;

public class FormCadastroAluguel extends FormCadastro {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7354502863008592691L;
	private JComboBox cbCliente;
	private JComboBox cbCarro;
	private JComboBox cbVendedor;
	private JTextField txSaida;
	private JTextField txChegada;
	private JTextField txObs;
	
	public FormCadastroAluguel(){
		panelCampos.setLayout(new GridBagLayout());
		
		setCbCarro(new JComboBox());
		setCbCliente(new JComboBox());
		setCbVendedor(new JComboBox());
		setTxSaida(new JTextField());
		setTxChegada(new JTextField());
		setTxObs(new JTextField());
		
		refresh();
		
		panelCampos.add("Cliente",getCbCliente());
		panelCampos.add("Carro",getCbCarro());
		panelCampos.add("Vendedor",getCbVendedor());
		panelCampos.add("Data de saída",getTxSaida());
		panelCampos.add("Data Prevista",getTxChegada());
		panelCampos.add("Observação",getTxObs());
		
	}
	
	public Rent prepare(){
		Rent r = new Rent();
		r.setAdditionalInformation(getTxObs().getText());
		r.setCar(getCbCarro().getModel().getSelectedItem().toString());
		r.setClient(getCbCliente().getModel().getSelectedItem().toString());
		r.setFuncionario(getCbVendedor().getModel().getSelectedItem().toString());
		r.setInitialDate(getTxSaida().getText());
		r.setEndingDate(getTxChegada().getText());
		return r;
	}
	
	public void handleUpdateClick(){
		if(getCbCarro().getSelectedIndex()==-1 || getCbCliente().getSelectedIndex()==-1 || getCbVendedor().getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null, "Verifique o preenchimento dos campos");
		} else {
			Starter.db.addAluguel(prepare());
			JOptionPane.showMessageDialog(null, "Aluguel Registrado com Sucesso");
			this.dispose();
		}

	}
	
	public JComboBox getCbCliente() {
		return cbCliente;
	}
	public void setCbCliente(JComboBox cbCliente) {
		this.cbCliente = cbCliente;
	}
	public JComboBox getCbCarro() {
		return cbCarro;
	}
	public void setCbCarro(JComboBox cbCarro) {
		this.cbCarro = cbCarro;
	}
	public JComboBox getCbVendedor() {
		return cbVendedor;
	}
	public void setCbVendedor(JComboBox cbVendedor) {
		this.cbVendedor = cbVendedor;
	}
	public JTextField getTxSaida() {
		return txSaida;
	}
	public void setTxSaida(JTextField txSaida) {
		this.txSaida = txSaida;
	}
	public JTextField getTxChegada() {
		return txChegada;
	}
	public void setTxChegada(JTextField txChegada) {
		this.txChegada = txChegada;
	}
	public JTextField getTxObs() {
		return txObs;
	}
	public void setTxObs(JTextField txObs) {
		this.txObs = txObs;
	}

	public void refresh() {
		String sqlCarro = "select car.vc_nome from aluguel as al, lf_cad_automoveis as car where car.in_cod_automovel not in (select cod_carro from aluguel) group by vc_nome";
		
		getCbCliente().setModel(Starter.db.getComboData("lf_cad_cliente", "vc_nome"));
		getCbCarro().setModel(Starter.db.getComboDataBySQL(sqlCarro, "vc_nome"));
		getCbVendedor().setModel(Starter.db.getComboData("lf_cad_funcionario", "vc_nome"));
		
	}
}
