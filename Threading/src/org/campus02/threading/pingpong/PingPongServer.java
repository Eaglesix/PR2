package org.campus02.threading.pingpong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(2222)) {
        	
			while(true) {
				System.out.println("waiting for connections");
				Socket client = ss.accept();
				System.out.println("client connected");
				
				ClientCommunication cc = 
						new ClientCommunication(client);
				Thread th = new Thread(cc);
				th.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}