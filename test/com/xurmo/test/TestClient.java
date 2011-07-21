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
		System.out.println("Connecting...");

	}

	public void connect() {
		String message = "Hello";

		try {
			System.out.println("Connecting...");
			clientSocket = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			out = new DataOutputStream(this.clientSocket.getOutputStream());
			try {
				writeToSocket(message);
				readFromSocket();
			} catch (Exception e) {
			}
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
		writeToSocket(message);

	}

	public static void main(String[] args) {

		TestClient t = new TestClient(6000, "127.0.0.1");
		t.connect();
	}

}
