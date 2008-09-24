package com.locafacil;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
