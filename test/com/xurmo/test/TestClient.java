package com.xurmo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TestClient {
	
	Socket clientSocket;
    String ip;
    int port;
	
	
	public TestClient(int port,String ip){
		
		this.ip=ip;
		this.port=port;
		
	}
	
	public void connect()
	{
		String message = "Hello";
		
		try
		{
		clientSocket = new Socket(ip, port);
		writeToSocket(clientSocket, message);
		readFromSocket(clientSocket);
		clientSocket.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	private void writeToSocket(Socket sock, String message) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(
											new OutputStreamWriter(sock.getOutputStream())), true);
		out.println(message);
		out.close();
	}

	private void readFromSocket(Socket sock) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		String message = in.readLine();
		System.out.println("Server says : " + message);
		in.close();
	}
	
	

}
