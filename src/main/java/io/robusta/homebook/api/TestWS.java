package io.robusta.homebook.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.robusta.homebook.dbinteraction.DBConnection;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

// Just a API for testing the DB interaction
@Path("test")
public class TestWS {

	

	@Path("test1")
	@GET
	public String test(){
		
		DBConnection conn = new DBConnection();
		String ok = conn.find();
		
		return ok;
	}

}