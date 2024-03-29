package com.locafacil.gui;

import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.WindowConstants;

import com.sun.org.apache.bcel.internal.generic.FMUL;

public class FormMain extends JFrame implements ActionListener {
	
	public static FormAluguel fmAluguel;
	public static FormAluguel getFmAluguel() {
		if(fmAluguel == null){
			fmAluguel = new FormAluguel();
		}
		return fmAluguel;
	}

	public static void setFmAluguel(FormAluguel fmAluguel) {
		FormMain.fmAluguel = fmAluguel;
	}

	public static FormSearchClient fmSearchCliente;
	public static FormSearchCar fmSearchCar; // ta statico pra evitar de criar varias instancias dos mesmos formularios
	
	public JInternalFrame actualFrame;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private Toolkit tool;
	private JMenuBar barraMenu;  
	private JMenu menuCadastro;  
	private JMenuItem itClientes;
	private JMenuItem itCars;
	private JMenuItem itAluguel;
	private PanelHeader header;
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
			getMenuCadastro().setText("Gerenciar");
			getMenuCadastro().add(getItClientes());
			getMenuCadastro().add(getItCars());
			getMenuCadastro().add(getItAluguel());
		}
		return menuCadastro;
	}
	public JMenuItem getItCars() {
		if(itCars==null){
			setItCars(new JMenuItem());
			getItCars().setText("Carros");
			getItCars().addActionListener(this);
		}
		return itCars;
	}

	public void setItCars(JMenuItem itCars) {
		this.itCars = itCars;
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
	public JMenuItem getItAluguel(){
		if(itAluguel == null){
			itAluguel = new JMenuItem();
			itAluguel.setText("Alugueis");
			itAluguel.addActionListener(this);
		}
			
		return itAluguel;
	}
	
	public JMenuItem getItClientes() {
		if(itClientes==null){
			setItClientes(new JMenuItem());
			getItClientes().setText("Clientes");
			getItClientes().addActionListener(this);
		}
		return itClientes;
	}
	/**
	 * @param itClientes the itClientes to set
	 */
	public void setItClientes(JMenuItem itClientes) {
		this.itClientes = itClientes;
	}

	public void actionPerformed(ActionEvent arg0) {
		if(actualFrame!=null){
			actualFrame.setVisible(false);
			actualFrame.dispose();
		}
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(itAluguel)){
			actualFrame = (JInternalFrame)getFmAluguel();
			this.add(getFmAluguel());
			getFmAluguel().setVisible(true);
		}
		if(arg0.getSource().equals(itClientes)){
			actualFrame = (JInternalFrame)getFmSearchCliente();
			this.add(getFmSearchCliente());
			getFmSearchCliente().setVisible(true);
		}
		if(arg0.getSource().equals(itCars)){
			actualFrame = (JInternalFrame)getFmSearchCliente();
			this.add(getFmSearchCar());
			getFmSearchCar().setVisible(true);
		}
	}

	public static FormSearchClient getFmSearchCliente() {
		if(fmSearchCliente==null){
			fmSearchCliente = new FormSearchClient();
		}
		return fmSearchCliente;
	}

	public static void setFmSearchCliente(FormSearchClient fmSearchCliente) {
		FormMain.fmSearchCliente = fmSearchCliente;
	}

	public static FormSearchCar getFmSearchCar() {
		if(fmSearchCar==null){
			fmSearchCar = new FormSearchCar();
		}
		return fmSearchCar;
	}

	public static void setFmSearchCar(FormSearchCar fmSearchCar) {
		FormMain.fmSearchCar = fmSearchCar;
	}


	
}
