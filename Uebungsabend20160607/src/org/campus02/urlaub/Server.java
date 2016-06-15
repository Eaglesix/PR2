package org.campus02.urlaub;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws DataFileException {
/*
		UrlaubManager manager = new UrlaubManager("D:\\temp\\urlaube.txt");
		
		for (Urlaub u : manager.load("Max Mustermann"))
			System.out.println(u.toString());
		*/
		
		
		
		ServerSocket server;
		ArrayList<ClientCommunication> connectedClients = new ArrayList<>(); 
		try {
			server = new ServerSocket(1111);
			
			ConsoleReader cr = new  ConsoleReader(server);
			Thread thConsole = new Thread(cr);
			thConsole.start();
			
			
			while (!cr.Stop)
			{
				Socket client = server.accept();
			
				ClientCommunication cc = new ClientCommunication(client);
				
				Thread th = new Thread (cc);
				th.start();
				System.out.println(cr.Stop);
				connectedClients.add(cc);
			}
			System.out.println("finished");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (ClientCommunication cc : connectedClients) {
			cc.stop();
		}

	}
	
	/*public static void processClient(Socket client)
	{
		try (
				BufferedReader br =
					new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter pw =
					new PrintWriter(new OutputStreamWriter(client.getOutputStream()))
				
				)
		{
			String line;
			while ((line = br.readLine()) != null
					&& !line.equalsIgnoreCase("exit"))
			{
				String[] commands = line.split(" ");
				if (commands[0].equals("GET"))
				{
					UrlaubManager manager = new UrlaubManager("D:\\temp\\urlaube.txt");
					ArrayList<Urlaub> urlaube =
							manager.load(commands[1]);
					
					for (Urlaub urlaub : urlaube) {
						pw.println(urlaub);
					}
					pw.flush();
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	

}
