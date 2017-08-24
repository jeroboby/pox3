package io.robusta.homebook.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.robusta.homebook.business.HomeBusiness;
import io.robusta.homebook.implementation.CityImplementation;
import io.robusta.homebook.implementation.HomeImplementation;




@Path("homes")
public class HomeWS {

	private HomeBusiness homeBusiness;
	private CityImplementation city;

	@Path("/{homeId}")
	@GET
	@Consumes( MediaType.APPLICATION_JSON )
	public HomeImplementation findById(@PathParam("homeId") int id){
		
		HomeImplementation home = homeBusiness.findById(id);
		if(home == null)
			return null;
		return home;
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public HomeImplementation createNewHome(HomeImplementation home){
	
		HomeImplementation homeNew = new HomeImplementation(city, 0, 0);
		homeNew.setCity(home.getCity());
		homeNew.setId(home.getId());
		homeNew.setPrice(home.getPrice());
		homeNew.setSurface(home.getSurface());
		homeBusiness.create(homeNew);
		
		return home;
		
	}
	
	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	@Path("/{homeId}")
	public HomeImplementation upDateHome(@PathParam("homeId") int id, HomeImplementation home){
		
		home.setCity(home.getCity());
		home.setId(home.getId());
		home.setPrice(home.getPrice());
		home.setSurface(home.getSurface());
		homeBusiness.updateHome(home);
		
		return home;
	}

	@DELETE
	@Path("/{homeId}")
	public void deleteHome(@PathParam("homeId") int id){
		homeBusiness.deleteHome(id);
	}
	
	
	
}
