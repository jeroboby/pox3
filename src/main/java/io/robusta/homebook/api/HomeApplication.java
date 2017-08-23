package io.robusta.homebook.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;


@ApplicationPath( "/api" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class HomeApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> result = new HashSet<>();
		result.add( HomeResource.class );
		return result;
	}
	
}