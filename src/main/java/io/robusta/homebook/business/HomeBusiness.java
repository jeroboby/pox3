package io.robusta.homebook.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import io.robusta.homebook.domain.Home;
import io.robusta.homebook.implementation.CityImplementation;
import io.robusta.homebook.implementation.HomeImplementation;

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
			return null;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	


	public HomeImplementation findById(int id) {
		PreparedStatement statement;
		try {

			String sql = "SELECT * from homes WHERE id = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			HomeImplementation home = null;
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

	public void deleteHome(int id) {

	}


	public void create(HomeImplementation homeNew) {
		// TODO Auto-generated method stub
		
	}
	
}
