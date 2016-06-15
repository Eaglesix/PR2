package org.campus02.urlaub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCommunication implements Runnable {

	private Socket client;
	private boolean stopRequested;
	
	ClientCommunication (Socket client)
	{
		this.client = client;
	}
	
	public void stop()
	{
		stopRequested = true;
		try {
			
			client.close(); // Close beendet die Verbindung löst Exception bei Read aus
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void processClient()
	{
		try (
				BufferedReader br =
					new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter pw =
					new PrintWriter(new OutputStreamWriter(client.getOutputStream()))
				
				)
		{
			String line;
			while (!stopRequested && (line = br.readLine()) != null
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
	}

	
	@Override
	public void run() {
		
		processClient();

	}

}
