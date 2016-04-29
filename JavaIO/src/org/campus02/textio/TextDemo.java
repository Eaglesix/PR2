package org.campus02.textio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextDemo {
	public static void main(String[] args) throws IOException {
		
		File f = new File("D:\\temp\\demo-text.txt");
		
		FileReader fl = new FileReader(f);
				BufferedReader br = new BufferedReader(
				fl); 

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
		
		br.close();
		
	}
}
