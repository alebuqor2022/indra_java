package com.indra.fundamentosjava.conectividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarCafes {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/indra2022";
		Connection con;
		Statement stmt;
		String query="Select * from cafes";		
		
		try {
			con=DriverManager.getConnection(url, "root", "1234");
			stmt=con.createStatement();
			//stmt.executeUpdate(query); --> da una respuesta booleana
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("Lista de Cafes");
			System.out.println("-----------------------------------");
			while(rs.next()) {
				System.out.println(rs.getString("cof_name")+ ", " + rs.getFloat(3));
			}
					
			stmt.close();
			con.close();				
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
