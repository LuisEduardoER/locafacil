package com.locafacil.gui;

import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class FormMain extends JFrame {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private Toolkit tool;
	private JMenuBar barraMenu;  
	private JMenu menuCadastro;  
	private JMenuItem itClientes; 
	private static final long serialVersionUID = 1L;

	public FormMain(){
		initialize();
	}
	
	private void initialize(){
		this.setTitle("LocaFacil");
		this.setJMenuBar(getBarraMenu());  
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(FormMain.WIDTH,FormMain.HEIGHT);
		this.setLocation((dim.width-FormMain.WIDTH)/2, (dim.height-FormMain.HEIGHT)/2);
		setVisible(true);
	}
	
	/**
	 * @return the barraMenu
	 */
	public JMenuBar getBarraMenu() {
		if(barraMenu==null){
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuCadastro());
		}
		return barraMenu;
	}
	/**
	 * @param barraMenu the barraMenu to set
	 */
	public void setBarraMenu(JMenuBar barraMenu) {
		this.barraMenu = barraMenu;
	}
	/**
	 * @return the menuCadastro
	 */
	public JMenu getMenuCadastro() {
		if(menuCadastro==null){
			setMenuCadastro(new JMenu());
			getMenuCadastro().setText("Cadastro");
			getMenuCadastro().add(getItClientes());
		}
		return menuCadastro;
	}
	/**
	 * @param menuCadastro the menuCadastro to set
	 */
	public void setMenuCadastro(JMenu menuCadastro) {
		this.menuCadastro = menuCadastro;
	}
	/**
	 * @return the itClientes
	 */
	public JMenuItem getItClientes() {
		if(itClientes==null){
			setItClientes(new JMenuItem());
			getItClientes().setText("Clientes");
		}
		return itClientes;
	}
	/**
	 * @param itClientes the itClientes to set
	 */
	public void setItClientes(JMenuItem itClientes) {
		this.itClientes = itClientes;
	}

}
