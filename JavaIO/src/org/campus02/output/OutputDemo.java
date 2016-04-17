package org.campus02.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputDemo {

	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\temp\\demo-text-out.txt");
		
		FileOutputStream fos = new FileOutputStream(file);
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject("mein output");
		fos.flush();

		fos.close();

	}

}
