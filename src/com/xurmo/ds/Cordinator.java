package com.xurmo.ds;
import java.net.ServerSocket;


public class Cordinator implements Runnable{
	
	public static Integer portno;
	
	public static ServerSocket listenSocket;
	public static Communication[] commobject;
	
	Thread[] communicationthread;
	
	public Cordinator()
	{
		portno=12345;
	}
	
	public void InitServer()
	{
		int i=0;
		
		try
		{   
			
			listenSocket=new ServerSocket(portno);
			commobject[i]=new Communication();
			
		}
		catch(Exception e)
		{
			//Showmessage("Connection Terminated");
			return;
		}
	}

	@Override
	public void run() {
		while(true)
		{
			
		}
		
	}

}
