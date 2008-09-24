package com.locafacil;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.locafacil.gui.FormSearch;

public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//MetalLookAndFeel.setCurrentTheme(new OrangeTheme());
		try {
			UIManager.setLookAndFeel( new com.nilo.plaf.nimrod.NimRODLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FormSearch fm = new FormSearch();
		//fm.pack();
		fm.setVisible(true);
	}
//Teste de Washington
}
