package io.robusta.homebook.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.robusta.homebook.business.HomeBusiness;
import io.robusta.homebook.implementation.CityImplementation;
import io.robusta.homebook.implementation.HomeImplementation;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


@Path("homes")
public class HomeWS {

	private HomeBusiness homeBusiness;
	private CityImplementation city;

	@Path("/{city}")
	@GET
	public List<HomeImplementation> findByCity(@PathParam("city") String city, int zipCode){
		
		List<HomeImplementation> homes = homeBusiness.findByCity(city, zipCode);
		
		return homes;
	}

	@POST
	public HomeImplementation createNewHome(HomeImplementation home){
		city.setName("toulouse");
		city.setZipCode(31000);
		home.setId(012345);
		home.setCity(city);
		home.setPrice(6525);
		home.setSurface(65);
		
		
		//home = homeBusiness.create();
		
		return home;
		
	}
}
