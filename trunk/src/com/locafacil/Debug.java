package com.locafacil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import com.locafacil.common.Address;
import com.locafacil.common.Client;
import com.locafacil.database.DataBase;

public class Debug {
	public Debug(){
		
	}
	
	public void debugRemoveClient(){
		Starter.db.deleteClientByCode(3);
	}
	
	public void debugAddClient(){
		Client c = new Client();
		c.setName("Daniel");
		c.setDocument("21265478");
		c.setBirthday(new Date().toString());
		Address ad = new Address();
		ad.setLongterm("rua do louco, 20");
		c.setAddress(ad);
		c.setEmail("jaja@jeje.com");
		c.setTelephone("(81)28129281");
		Starter.db.addClient(c);
	}
	
	public void debugDB(){
		DataBase db = DataBase.getDataBase();
		ResultSet rs = db.getResultset(" SELECT * FROM `lf_cad_cliente` LIMIT 0 , 30 ");
		System.out.println("iniciando conexao com BD");
		try {
			while(rs.next()){
				System.out.println(rs.getString("vc_nome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void debugClients(){
		Vector<Client> vt = Starter.db.getClients();
		Iterator<Client> it = vt.iterator();
		while(it.hasNext()){
			Client cl = it.next();
			System.out.println(cl.getName());
		}
	}
	
}
