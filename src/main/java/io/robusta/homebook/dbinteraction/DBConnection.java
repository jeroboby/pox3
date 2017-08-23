package io.robusta.homebook.dbinteraction;

import java.sql.*;

public class DBConnection {

	Connection conn;
	
	public DBConnection() {
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homebookdb", "root", "" );
		}
		catch( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String find() {
		Statement statement;
		try {
			statement = conn.createStatement();
	
		ResultSet rs = statement.executeQuery( "SELECT * from homes" );

		while( rs.next() )
		{
			int id = rs.getInt( "id" );
			String adress = rs.getString( "adress" );
			
		}
		conn.close();
		return "ok";
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
