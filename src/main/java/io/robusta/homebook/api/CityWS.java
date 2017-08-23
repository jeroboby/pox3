package io.robusta.homebook.api;


import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("cities")
public class CityWS {

	@Path("test")
	@GET
	public String test() {
		return "test";

		
	}
	
	
}
