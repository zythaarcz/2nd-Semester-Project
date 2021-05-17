package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import databaselayer.DBConnection;

public class TestDatabaseAccess {
	
	DBConnection connection = null;

	@Before
	public void setUp() {
		connection = DBConnection.getInstance();
	}

	@Test
	public void wasConnected() {
		assertNotNull("Connected - connection cannot be null", connection);
		
		DBConnection.closeConnection();
		boolean wasNullified = DBConnection.instanceIsNull();
		assertTrue("Disconnected - instance set to null", wasNullified);
		
		connection = DBConnection.getInstance();
		assertNotNull("Connected - connection cannot be null", connection);		
	}

}
