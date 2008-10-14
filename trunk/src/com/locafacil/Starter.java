package com.locafacil;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.locafacil.database.DataBase;
import com.locafacil.gui.FormAluguel;
import com.locafacil.gui.FormBaixaAluguel;
import com.locafacil.gui.FormCadastro;
import com.locafacil.gui.FormCadastroAluguelCarro;
import com.locafacil.gui.FormCadastroCarro;
import com.locafacil.gui.FormCadastroClient;
import com.locafacil.gui.FormCadastroFuncionario;
import com.locafacil.gui.FormMain;
import com.locafacil.gui.FormSearch;

public class Starter {
	
	public static DataBase db;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		db = new DataBase();
		setupLookAndFeel();
		FormMain fm = new FormMain();
		//FormCadastroAluguelCarro fm= new FormCadastroAluguelCarro();
		//FormBaixaAluguel fm = new FormBaixaAluguel();
		//FormCadastroAluguelCarro fm= new FormCadastroAluguelCarro();
		//FormCadastroClient fm = new FormCadastroClient();
		//FormCadastroFuncionario fm = new FormCadastroFuncionario();
		//debug();
		fm.setVisible(true);
	}
	
	public static void debug(){
		Debug debug = new Debug();
		debug.debugRemoveClient();
	}
	
	public static void setupLookAndFeel(){
		try {
			UIManager.setLookAndFeel( new com.nilo.plaf.nimrod.NimRODLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
