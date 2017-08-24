package io.robusta.homebook.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class HomeBusinessTest {
	

		HomeBusiness homeConn;
		
		@Before
		public void setUp(){

				try {
					homeConn = new HomeBusiness();
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
			assertEquals(1,homeConn.findAll().size());
		}

		@Test
		public void testFindById() {
			assertEquals(666,homeConn.findById(48258).getSurface());
		}

		@Test
		public void testFindByHome() {
			fail("Not yet implemented");
		}

		@Test
		public void testUpdateHome() {
			fail("Not yet implemented");
		}

		@Test
		public void testDeleteHome() {
			fail("Not yet implemented");
		}

		
}
