package com.xurmo.ds;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Cordinator {

	public static Integer portno;

	public static ServerSocket listenSocket;
	public static Communication[] commobject;

	Thread[] communicationthread;

	public Cordinator(int number) {
		portno = 6000;
		commobject = new Communication[number];
		communicationthread = new Thread[number];
	}

	public void InitServer() {
		Socket sock;
		int count = 1;

		try {
			listenSocket = new ServerSocket(portno);
			while (true) {
				System.out.println("Waiting for Connection "+count);
				sock = listenSocket.accept();
				commobject[count] = new Communication(count, sock);
				communicationthread[count] = new Thread(commobject[count]);
				communicationthread[count].start();
				count++;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}
	
	public String testchat()
	{
		Socket sock;
		try {
			listenSocket = new ServerSocket(portno);
			sock = listenSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			DataOutputStream out=new DataOutputStream(sock.getOutputStream());
			out.writeBytes("OK"+"\n");
			return in.readLine();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "failed";
		}
		
	}

	public static void main(String[] args) {

		Cordinator cobj = new Cordinator(10);
		cobj.InitServer();

	}

}
