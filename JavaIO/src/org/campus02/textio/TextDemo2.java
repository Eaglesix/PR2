package org.campus02.textio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TextDemo2 {
	public static void main(String[] args) throws IOException {
		
		File f = new File("D:\\temp\\demo-text-input.txt");
		
		FileWriter fw = new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)); 

		String line;
		while (!(line = br.readLine()).equalsIgnoreCase("stop"))
		{
			pw.println(line);
		}
		
		br.close();
		pw.flush();
		pw.close();
		
	}
}
