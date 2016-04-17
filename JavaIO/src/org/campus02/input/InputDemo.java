package org.campus02.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputDemo {

	public static void main(String[] args) throws IOException {

		File file = new File("D:\\temp\\demo-text.txt");
		
		FileInputStream fis = new FileInputStream(file);
		int byteRead;
		while ((byteRead = fis.read()) != -1)
		{
			char[] ch = Character.toChars(byteRead);
			System.out.print(ch[0]);
		}
		fis.close();
	}

}
