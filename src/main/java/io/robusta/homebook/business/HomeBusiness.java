package io.robusta.homebook.business;

import io.robusta.homebook.domain.City;
import io.robusta.homebook.domain.Home;

import io.robusta.homebook.implementation.CityImplementation;
import io.robusta.homebook.implementation.HomeImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class HomeBusiness {

	Connection conn;

	public HomeBusiness() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homebookdb", "root", "");
	}

	public List<Home> findAll() {
		Statement statement;
		try {
			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * from homes");

			List<Home> homes = new ArrayList<Home>();

			while (rs.next()) {

				int id = rs.getInt("id");
				int zip_code = rs.getInt("zip_code");
				int surface = rs.getInt("surface");
				int price = rs.getInt("price");

				CityImplementation city = new CityImplementation(zip_code, "example");
				Home home = new HomeImplementation(id, city, surface, price);
				homes.add(home);
			}
			conn.close();
			return homes;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
		// TODO On ne ferme pas la connexion s'il y a un soucis durant
		// l'interction avec la DB.... A GERER
	}

	public Home findById(int id) {
		PreparedStatement statement;
		try {

			String sql = "SELECT * from homes WHERE id = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			Home home = null;
			while (rs.next()) {

				int zip_code = rs.getInt("zip_code");
				int surface = rs.getInt("surface");
				int price = rs.getInt("price");
				CityImplementation city = new CityImplementation(zip_code, "example");
				home = new HomeImplementation(id, city, surface, price);

			}
			conn.close();
			return home;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public List<HomeImplementation> findByCity(String city, int zipCode) {

		return null;

	}

	public void updateHome(Home user) {

	}

	public void deleteHome(Home user) {

	}

}
