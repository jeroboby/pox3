package io.robusta.homebook.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath( "/api" )
public class HomeApplication extends Application
{
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> result = new HashSet<>();
		result.add( HomeWS.class );
		result.add( CityWS.class );

		return result;
	}

}
