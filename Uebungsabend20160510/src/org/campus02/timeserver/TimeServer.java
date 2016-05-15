package org.campus02.timeserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket server 
				= new ServerSocket(1234);
			
			while (true)
			{
				Socket client = 
						server.accept();
				
				try (
					OutputStreamWriter osw = 
					  new OutputStreamWriter(client.getOutputStream());
					BufferedWriter bw = new BufferedWriter(osw);
						)
				{
					bw.write(LocalDateTime.now().toString());
					bw.flush();
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
