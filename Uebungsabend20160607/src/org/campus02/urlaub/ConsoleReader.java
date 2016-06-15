package org.campus02.urlaub;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class ConsoleReader implements Runnable {

	private ServerSocket socket;
	
	public ConsoleReader(ServerSocket socket)
	{
		this.socket = socket;
	}
	
	public boolean Stop;
	@Override
	public void run() {
		
		Stop = false;
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			if (sc.nextLine().equals("exit"))
			{
				System.out.println("stopped via exit");
				Stop = true;
				break;
			}
		}
		
		try {
			
			socket.close(); // Close beim ServerSocket beendet die Verbindung und löst Exception bei accept aus
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
