package com.xurmo.ds;

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

	public static void main(String[] args) {

		Cordinator cobj = new Cordinator(10);
		cobj.InitServer();

	}

}
