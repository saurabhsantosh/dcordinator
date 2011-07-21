package com.xurmo.test;


import java.net.Socket;

import org.junit.Test;

import com.xurmo.ds.Communication;
import com.xurmo.ds.Cordinator;
import junit.framework.TestCase;


public class CordinatorTest extends TestCase {
	
	Cordinator c;
	
	@Override
	protected void setUp() throws Exception {
           c=new Cordinator(10);
		
	}
	
	@Test
	
	public void testConnection()
	{
		c.InitServer();
		TestClient t=new TestClient(6000, "127.0.0.1");
		t.connect();
	}

}
