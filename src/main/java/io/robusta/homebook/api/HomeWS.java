package io.robusta.homebook.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.robusta.homebook.implementation.HomeImplementation;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


@Path("homes")
public class HomeWS {

	

	@Path("/{city}")
	@GET
	public List<HomeImplementation> findByCity(@PathParam("city") String city){
		List<HomeImplementation> homes = new ArrayList<>();

		
		for(HomeImplementation home:homes)
		{
		homes.add(home);
		}
		
		return homes;
	}

}
