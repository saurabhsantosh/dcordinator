package com.xurmo.test;

import java.net.Socket;

import org.junit.Test;

import com.xurmo.ds.Communication;

public class CommunicationTest {
	
	@Test
	public void testInitialization(){
		Socket s = new Socket();
		new Communication(s);
	}

}
