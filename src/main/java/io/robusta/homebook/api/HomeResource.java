package io.robusta.homebook.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("homes")
public class HomeResource {

	

	@Path("test")
	@GET
	public String test(){
		return "test";
	}
	

}
