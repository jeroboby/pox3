package io.robusta.homebook.api;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.robusta.homebook.dbinteraction.DBConnection;


@Path("homes")
public class HomeResource {

	

	@Path("test")
	@GET
	public String test(){
		DBConnection conn = new DBConnection();
		String res;
		try {
			res = conn.find();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	

}
