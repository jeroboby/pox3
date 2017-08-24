package io.robusta.homebook.business;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class CityBusinessTest {

	CityBusiness cityConn;
	
	@Before
	public void setUp(){

			try {
				cityConn = new CityBusiness();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	


	@Test
	public void testFindAll() {
		assertEquals(1,cityConn.findAll().size());
	}

	@Test
	public void testFindByZipCode() {
		assertEquals("CityExample",cityConn.findByZipCode(66666).getName());
	}

	@Test
	public void testFindByCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCity() {
		fail("Not yet implemented");
	}

	
}
