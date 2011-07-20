package com.xurmo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Communication implements Runnable {
	
	private Socket childSocket;

	public Communication(Socket s) {
		this.childSocket = s;
	}

	@Override
	public void run() {
		
	}
	
	public String readFromSocket() throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(this.childSocket.getInputStream()));
		String input = in.readLine();
		System.out.println("test: " + input);
		in.close();
		return input;
	}
	
	public void writeToSocket(String message) throws IOException {
		PrintWriter out = new PrintWriter(this.childSocket.getOutputStream(), true);
		out.println(message);
		out.close();
	}
}
