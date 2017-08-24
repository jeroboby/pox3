package io.robusta.homebook.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.robusta.homebook.dbinteraction.DBConnection;
import io.robusta.homebook.domain.City;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

// Just a API for testing the DB interaction
@Path("test")
public class TestWS {

	

	@Path("test1")
	@GET
	public List<City> test(){
		
		DBConnection conn = new DBConnection();
		List<City> cities = conn.find();
		
		return cities;
	}

}