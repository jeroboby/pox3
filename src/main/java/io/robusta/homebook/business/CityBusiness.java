package io.robusta.homebook.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.robusta.homebook.domain.City;
import io.robusta.homebook.implementation.CityImplementation;

public class CityBusiness {

	Connection conn;
	
	public CityBusiness() throws ClassNotFoundException, SQLException {
		Class.forName( "com.mysql.jdbc.Driver" );
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homebookdb", "root", "" );
	}
	
	public List<City> findAll() {
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

			e.printStackTrace();
			return null;
		}
		//TODO On ne ferme pas la connexion s'il y a un soucis durant l'interction avec la DB.... A GERER
	}
	
	
	public City findByZipCode(int zipCode) {
		PreparedStatement statement;
		try {
			
			String sql = "SELECT * from cities WHERE zip_code = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, zipCode);
			
			ResultSet rs = statement.executeQuery(  );
			
			City city = null;
			while( rs.next() )
			{
				
				String name = rs.getString("name");
				city = new CityImplementation(zipCode, name);

			}
			conn.close();
			return city;
		
		
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	
	public List<City> findByCity(String city, String zipCode) {


		return null;

	}



	public void updateCity(City user) {


	}

	public void deleteCity(City user) {

	}
	

}
