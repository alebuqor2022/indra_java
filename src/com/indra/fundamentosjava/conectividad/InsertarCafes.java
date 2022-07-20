package com.indra.fundamentosjava.conectividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarCafes {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/indra2022";
		Connection con;
		Statement stmt;
		
		
		try {
			con=DriverManager.getConnection(url, "root", "1234");
			stmt=con.createStatement();
			//stmt.executeUpdate(query);
			stmt.executeUpdate("insert into cafes values ('Colombiano',101,7.99,0,0)");
			stmt.executeUpdate("insert into cafes values ('Frances Tostado',150,9.99,0,0)");
			stmt.executeUpdate("insert into cafes values ('Espresso',101,5.99,0,0)");
			stmt.executeUpdate("insert into cafes values ('Colombiano Decaf',150,8.99,0,0)");
			stmt.executeUpdate("insert into cafes values ('CafeLatte',101,7.99,0,0)");
					
			
			stmt.close();
			con.close();				
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}

	}

}
