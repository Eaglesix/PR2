package org.campus02.bufferedinput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\temp\\demo-text.txt");
		
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
	
		int byteRead;
		while ((byteRead = bis.read()) != -1)
		{
			char[] ch = Character.toChars(byteRead);
			System.out.print(ch[0]);
		}
		bis.close();
	}

}
