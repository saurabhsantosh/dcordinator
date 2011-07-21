package com.xurmo.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
			writeToSocket(clientSocket, message);
			readFromSocket(clientSocket);
			in.close();
			out.close();
			clientSocket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void writeToSocket(Socket sock, String message) throws IOException {

		out.writeBytes(message + "\n");

	}

	private void readFromSocket(Socket sock) throws IOException {

		String message = in.readLine();
		System.out.println("Server says : " + message);

	}

}
