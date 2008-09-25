package com.locafacil;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.locafacil.database.DataBase;
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
		//FormSearch fm = new FormSearch();
		//fm.setVisible(true);
		//Debug db = new Debug();
		//db.debugClients();
	}
	public static void setupLookAndFeel(){
		try {
			UIManager.setLookAndFeel( new com.nilo.plaf.nimrod.NimRODLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
