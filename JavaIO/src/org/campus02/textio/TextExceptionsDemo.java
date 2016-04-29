package org.campus02.textio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.spi.CharsetProvider;

public class TextExceptionsDemo {
	public static void main(String[] args)  {
		
		File f = new File("D:\\temp\\demo-text.txt");
		
		try (BufferedReader br = 
				new BufferedReader(
					new InputStreamReader(
						new FileInputStream(f), StandardCharsets.UTF_8)))
		{
			String line;
			while ((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}

		
		
	}
}
