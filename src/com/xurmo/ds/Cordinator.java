package com.xurmo.ds;
import java.net.ServerSocket;
import java.net.Socket;


public class Cordinator {
	
	public static Integer portno;
	
	public static ServerSocket listenSocket;
	public static Communication[] commobject;
	
	Thread[] communicationthread;
	
	public Cordinator()
	{
		portno=12345;
	}
	
	private void InitServer()
	{
		Socket sock;
		int count=0;
		
		
		try
		{   
		    listenSocket=new ServerSocket(portno);
			while(true)
			{
			sock=listenSocket.accept();
			System.out.println("Client : "+count+" Connected");
			commobject[count]=new Communication(sock);
			communicationthread[count]=new Thread(commobject[count]);
			communicationthread[count].start();
			count++;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
		
	}

public static void main(String[] args) {
	
	Cordinator cobj=new Cordinator();
	cobj.InitServer();
	
}	
	
	
}
