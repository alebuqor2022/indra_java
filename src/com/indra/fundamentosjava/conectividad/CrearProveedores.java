package com.indra.fundamentosjava.conectividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearProveedores {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/indra2022";
		Connection con;
		Statement stmt;
		
		String query;
		query="create table suppliers (sup_name varchar(32), " +
				"sup_id int, " +
				"street varchar(40), " +
				"city varchar(20), " +
				"state char(2), " + 
				"zip char(5))";
		
		try {
			con=DriverManager.getConnection(url, "root", "1234");
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			
			stmt.close();
			con.close();				
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}

	}

}
