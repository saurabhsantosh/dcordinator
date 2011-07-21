package com.xurmo.ds;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Communication implements Runnable {

	private Socket childSocket;
	BufferedReader in;
	DataOutputStream out;
	int id;

	public Communication(int count, Socket s) {

		this.id = count;
		this.childSocket = s;
		try {
			in = new BufferedReader(new InputStreamReader(
					childSocket.getInputStream()));
			out = new DataOutputStream(childSocket.getOutputStream());
		} catch (Exception e) {

		}
		System.out.println("Client : " + this.id + " Connected");
	}

	@Override
	public void run() {

		while (true) {
			try {

				System.out.println("Client Says : " + readFromSocket());
				writeToSocket("Hey");
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}

		try {
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String readFromSocket() throws IOException {
		String input = in.readLine();
		return input;
	}

	public void writeToSocket(String message) throws IOException {
		out.writeBytes(message + "\n");

	}
}
