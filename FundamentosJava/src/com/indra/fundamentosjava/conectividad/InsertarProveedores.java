package com.indra.fundamentosjava.conectividad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarProveedores {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/indra2022";
		Connection con;
		Statement stmt;
		
		try {
			con=DriverManager.getConnection(url, "root", "1234");
			stmt=con.createStatement();
			stmt.executeUpdate("insert into SUPPLIERS " +
	                 "values('Superior Coffee', 150, '1 Party Place', " +
				 "'Mendocino', 'CA', '95460')");
		
			stmt.executeUpdate("insert into SUPPLIERS " +
				"values( 'Acme, Inc.',101, '99 Market Street', " +
				"'Groundsville', 'CA', '95199')");
	
			stmt.executeUpdate("insert into SUPPLIERS " +
	                 "values( 'The High Ground', 190,'100 Coffee Lane', " +
				 "'Meadows', 'CA', '93966')");
			
			stmt.close();
			con.close();
			
		}catch(SQLException e1) {
			System.err.print("Query invalida");
		}
	}

}
