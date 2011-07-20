import java.net.ServerSocket;


public class Cordinator implements Runnable{
	
	public static Integer portno;
	
	public static ServerSocket listenSocket;
	public static Communication[] commobject;
	
	Thread[] communicationthread;
	
	public void InitServer()
	{
		int i=0;
		
		portno=12345;
		
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
		// TODO Auto-generated method stub
		
	}

}
