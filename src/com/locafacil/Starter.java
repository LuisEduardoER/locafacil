package com.locafacil;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.locafacil.gui.FormSearch;

public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setupLookAndFeel();
		FormSearch fm = new FormSearch();
		fm.setVisible(true);
		Debug db = new Debug();
		db.debugDB();
	}
	public static void setupLookAndFeel(){
		try {
			UIManager.setLookAndFeel( new com.nilo.plaf.nimrod.NimRODLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
