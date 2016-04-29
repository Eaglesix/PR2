package org.campus02.textio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextDemo2 {
	public static void main(String[] args) throws IOException {
		
		//File f = new File("D:\\temp\\demo-text.txt");
		
		//FileReader fl = new FileReader(f);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)); 

		String line;
		while (!(line = br.readLine()).equals("stop"))
		{
			System.out.println(line);
		}
		
		br.close();
		
	}
}
