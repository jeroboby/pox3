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

	public CityBusiness() {
		

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homebookdb", "root", "");

			} catch (ClassNotFoundException| SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}


	}
	public List<City> findAll() {
		Statement statement;
		try {
			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * from cities");

			List<City> cities = new ArrayList<City>();

			while (rs.next()) {

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
		// TODO On ne ferme pas la connexion s'il y a un soucis durant
		// l'interction avec la DB.... A GERER
	}

	public City findByZipCode(int zipCode) {
		PreparedStatement statement;
		try {

			String sql = "SELECT * from cities WHERE zip_code = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, zipCode);

			ResultSet rs = statement.executeQuery();

			City city = null;
			while (rs.next()) {

				String name = rs.getString("name");
				city = new CityImplementation(zipCode, name);

			}
			return city;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	public void addCity(City city) {

		if (this.findByZipCode(city.getZipCode()) != null) {
			throw new RuntimeException("City already in DB. Use update instead");
		}
		PreparedStatement statement;
		try {
			String sql = "insert into cities values (?,?)";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, city.getZipCode());
			statement.setString(2, city.getName());

			int rs = statement.executeUpdate();

			if (rs != 1) {
				throw new RuntimeException("Too many row changes in DB from the add function. This might not be a pb");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateCity(City city) {

		if (this.findByZipCode(city.getZipCode()) == null) {
			throw new RuntimeException("City not already in DB. Use add instead");
		}
		PreparedStatement statement;
		try {
			String sql = "update cities set name = ? where zip_code = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, city.getName());
			statement.setInt(2, city.getZipCode());

			int rs = statement.executeUpdate();

			if (rs != 1) {
				throw new RuntimeException("Too many row changes in DB from the add function. This might not be a pb");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void deleteCity(City city) {
		if (this.findByZipCode(city.getZipCode()) == null) {
			throw new RuntimeException("City not  in DB");
		}
		PreparedStatement statement;
		try {
			String sql = "Delete from cities where zip_code = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, city.getZipCode());

			int rs = statement.executeUpdate();

			if (rs != 1) {
				throw new RuntimeException("Too many row changes in DB from the delete function. There might habe be a pb in DB");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
