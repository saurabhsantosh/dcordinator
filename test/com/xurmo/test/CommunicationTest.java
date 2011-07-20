package com.xurmo.test;

import java.net.Socket;

import junit.framework.TestCase;

import org.junit.Test;

import com.xurmo.ds.Communication;

public class CommunicationTest extends TestCase {
	
	Communication c;
	Thread testThread;
	
	@Override
	protected void setUp() throws Exception {
		Socket s = new Socket();
		c = new Communication(s);
		this.testThread = new Thread(c);
	}
	
	@Override
	protected void tearDown() throws Exception {
		c = null;
	}
	
	@Test
	public void testThreadStart() {
		testThread.start();
	}
	
	@Test
	public void testReadFromSocket() {
		
	}

}
