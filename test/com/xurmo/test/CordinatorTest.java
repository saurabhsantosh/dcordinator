package com.xurmo.test;

import org.junit.Test;

import com.xurmo.ds.Cordinator;
import junit.framework.TestCase;

public class CordinatorTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		Cordinator c = new Cordinator(10);
		c.InitServer();
	}

	@Test
	public void testConnection() {
		TestClient t = new TestClient(6000, "127.0.0.1");
		t.connect();
	}

}
