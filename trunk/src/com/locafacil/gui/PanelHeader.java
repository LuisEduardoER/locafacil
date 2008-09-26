package com.locafacil.gui;

import java.awt.Font;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelHeader extends JPanel {

	private Font font;
	private String label;
	private JLabel lbHeader;
	
	private static final long serialVersionUID = 1L;

	public PanelHeader(String arg){
		super();
		font = new Font("Verdana", Font.BOLD, 19);
		setLabel(arg);
		setLbHeader(new JLabel(getLabel()));
		this.add(getLbHeader());
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public JLabel getLbHeader() {
		return lbHeader;
	}

	public void setLbHeader(JLabel lbHeader) {
		this.lbHeader = lbHeader;
		getLbHeader().setFont(font);
		getLbHeader().setText("<html><font color=#FF3311>"+getLabel()+"</font>");
		
	}
	
}
