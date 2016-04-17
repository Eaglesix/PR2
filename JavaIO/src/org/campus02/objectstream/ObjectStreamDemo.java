package org.campus02.objectstream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File file = new File("D:\\temp\\object.dat");
		
		// Schreiben
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	
		String outputText = "Hello ObjectOutputStream";
		oos.writeObject(outputText);
		oos.close();
		
		// Lesen
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		String inputText = (String) ois.readObject();
		System.out.println(inputText);
		ois.close();
	}

}
