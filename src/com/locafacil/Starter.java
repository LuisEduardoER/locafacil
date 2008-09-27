package com.locafacil;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.locafacil.database.DataBase;
import com.locafacil.gui.FormCadastro;
import com.locafacil.gui.FormCadastroClient;
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
		//FormMain fm = new FormMain();
		FormCadastroClient fm = new FormCadastroClient();
		fm.setVisible(true);
	}
	public static void setupLookAndFeel(){
		try {
			UIManager.setLookAndFeel( new com.nilo.plaf.nimrod.NimRODLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
