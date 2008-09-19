package com.locafacil;

import org.swingml.SwingMLInitializationError;
import org.swingml.SwingMLRenderer;

public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] params = new String[3];
		params[0] = "file:///J:/Documents%20and%20Settings/Administrador/workspace/LocaFacil/src/com/locafacil/gui/formTeste.xml";
		params[1] = "400";
		params[2] = "400";
		try {
			SwingMLRenderer.main(params);
		} catch (SwingMLInitializationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//Teste de Washington
}
