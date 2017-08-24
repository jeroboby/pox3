package io.robusta.homebook.api;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import io.robusta.homebook.business.HomeBusiness;
import io.robusta.homebook.implementation.HomeImplementation;


@Path("cities")
public class CityWS {

	@Path("test")
	@GET
	public String test() {
		return "test";

		
	}
	private HomeBusiness homeBusiness;

	
	@Path("/{city}")
	@GET
	@Consumes( MediaType.APPLICATION_JSON )
	public List<HomeImplementation> findByCity(@PathParam("city") String city, int zipCode){
		
		List<HomeImplementation> homes = homeBusiness.findByCity(city, zipCode);
		if(homes == null)
			return null;
		return homes;
	}
	
}
