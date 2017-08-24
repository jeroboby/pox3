package io.robusta.homebook.dbinteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.robusta.homebook.domain.City;
import io.robusta.homebook.domain.Home;
import io.robusta.homebook.implementation.CityImplementation;
import io.robusta.homebook.implementation.HomeImplementation;

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
	
	public List<City> find() {
		Statement statement;
		try {
			statement = conn.createStatement();
	
			ResultSet rs = statement.executeQuery( "SELECT * from cities" );
			
			List<City> cities = new ArrayList<City>();

			
			while( rs.next() )
			{
				
				int zipCode = rs.getInt("zip_code");
				String name = rs.getString("name");
				City city = new CityImplementation(zipCode, name);
				cities.add(city);
			}
			conn.close();
			return cities;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
