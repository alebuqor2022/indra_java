package com.indra.fundamentosjava.conectividad;
import java.sql.*;

public class CrearCafe {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/indra2022";
		Connection con;
		Statement stmt;
		
		String query;
		query="create table cafes "+
				"(COF_NAME varchar(32), " +
				"SUP_ID int, " +
				"PRICE float, " +
				"SALES int, " +
				"TOTAL int)";
		// comprueba la existencia del driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		// intenta realizar la conexion
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
