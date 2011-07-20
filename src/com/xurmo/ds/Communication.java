package com.xurmo.ds;

import java.net.Socket;

public class Communication implements Runnable {
	
	private Socket mainSocket;

	public Communication(Socket s) {
		this.mainSocket = s;
	}

	@Override
	public void run() {
		for(int i=0; i< 10; i++){
			System.out.println("Testing thread");
		}
	}
}
