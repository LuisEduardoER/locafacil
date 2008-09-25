package com.locafacil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import com.locafacil.common.Client;
import com.locafacil.database.DataBase;

public class Debug {
	public Debug(){
		
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
