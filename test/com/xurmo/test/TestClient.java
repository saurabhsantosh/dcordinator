package com.xurmo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TestClient {

	Socket clientSocket;
	DataOutputStream out;
	BufferedReader in;
	String ip;
	int port;

	public TestClient(int port, String ip) {

		this.ip = ip;
		this.port = port;

	}

	public void connect() {
		String message = "Hello";

		try {
			clientSocket = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			out = new DataOutputStream(this.clientSocket.getOutputStream());
			writeToSocket(message);
			readFromSocket();
			in.close();
			out.close();
			clientSocket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void writeToSocket(String message) throws IOException {

		out.writeBytes(message + "\n");

	}

	private void readFromSocket() throws IOException {

		String message = in.readLine();
		System.out.println("Server says : " + message);

	}

}
