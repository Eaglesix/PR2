package org.campus02.textio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TextDemo {
	public static void main(String[] args) 
			{
		
		
		
		File f = new File("D:\\temp\\demo-text.txt");
		try (
			FileReader fl = new FileReader(f);
			BufferedReader br = new BufferedReader(fl); 
			)
		{
					String line;
			while ((line = br.readLine()) != null)
			{
				/*String ausgabe ="";
				for (int i = 0; i < line.length(); i++)
				{
					if (line.charAt(i) == ';')
					{
						System.out.println(ausgabe);
						ausgabe = "";
					}
					else 
					{
						ausgabe = ausgabe + line.charAt(i);
					}
				}
				System.out.println(ausgabe);
				*/
				
				String[] parts = line.split(";");
				for (String column  : parts) {
					System.out.println(column);
				}
				
			}
			
			
		}
		catch(FileNotFoundException ex)
		{
			// user aktion
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
}
