package com.locafacil.gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BasicPanel extends JPanel {
	public void add(String label, JComponent componente, String label2, JComponent componente2) {   
        GridBagConstraints cons = new GridBagConstraints();   
        cons.fill = GridBagConstraints.BOTH;   
        cons.insets = new Insets(4,4,4,4);   
  
        cons.fill = GridBagConstraints.NONE;   
        cons.anchor = GridBagConstraints.NORTHWEST;   
        cons.weightx = 0;   
        cons.gridwidth = 1;   
        this.add(new JLabel(label), cons);   
           
        cons.weightx = 1;   
        cons.gridwidth = 1;   
        cons.fill = GridBagConstraints.BOTH;   
        this.add(componente, cons);   
  
        cons.fill = GridBagConstraints.NONE;   
        cons.weightx = 0;   
        cons.gridwidth = 1;   
        this.add(new JLabel(label2), cons);   
           
        cons.weightx = 1;   
        cons.fill = GridBagConstraints.BOTH;   
        cons.gridwidth = GridBagConstraints.REMAINDER;   
        this.add(componente2, cons);   
    }       
	
	public void add(PanelHeader header) {   
        GridBagConstraints cons = new GridBagConstraints();   
        cons.anchor = GridBagConstraints.CENTER;   
        cons.insets = new Insets(10,10,10,10);   
   
           
        cons.fill = GridBagConstraints.CENTER;   
        cons.weightx = 1;   
        cons.gridwidth = GridBagConstraints.REMAINDER;   
        this.add(header, cons);  
    }
	
	public void add(String label) {   
        GridBagConstraints cons = new GridBagConstraints();   
        cons.anchor = GridBagConstraints.CENTER;   
        cons.insets = new Insets(4,4,4,4);   
   
           
        cons.fill = GridBagConstraints.CENTER;   
        cons.weightx = 1;   
        cons.gridwidth = GridBagConstraints.REMAINDER;   
        this.add(new JLabel(label), cons);  
    }
	
	public void add(JButton button) {   
        GridBagConstraints cons = new GridBagConstraints();   
        cons.anchor = GridBagConstraints.SOUTHEAST;   
        cons.insets = new Insets(4,4,8,4);   
   
           
        cons.fill = GridBagConstraints.NONE;   
        cons.weightx = 1;   
        cons.gridwidth = GridBagConstraints.REMAINDER;   
        this.add(button, cons);  
    }
	
    public void add(String label, JComponent componente ) {   
        GridBagConstraints cons = new GridBagConstraints();   
        cons.fill = GridBagConstraints.NONE;   
        cons.anchor = GridBagConstraints.NORTHWEST;   
        cons.insets = new Insets(4,4,4,4);   
  
        cons.weightx = 0;   
        cons.gridwidth = 1;   
        this.add(new JLabel(label), cons);   
           
        cons.fill = GridBagConstraints.BOTH;   
        cons.weightx = 1;   
        cons.gridwidth = GridBagConstraints.REMAINDER;   
        this.add(componente, cons);   
    }  
}
