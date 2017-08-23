package io.robusta.homebook.dbinteraction;

import java.sql.*;

public class DBConnection {

	Connection conn;
	
	public DBConnection() {
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homedb", "root", "" );
		}
		catch( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Pb with connection");
		}
		
	}
	
	public String find() throws SQLException{
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery( "SELECT * from homes" );

		while( rs.next() )
		{
			int id = rs.getInt( "id" );
			String adress = rs.getString( "adress" );
			
		}
		conn.close();
		return "ok";
	}
	
}
