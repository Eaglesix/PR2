package org.campus02.objectstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File file = new File("D:\\temp\\object2.dat");
		
		// Schreiben
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);


	
		Person p = new Person("Max", "Mustermann", 20);
		Person p1 = new Person("Susi1", "Sorglos", 22);
		oos.writeObject(p);
		oos.writeObject(p1);
		bos.flush();
		oos.close();
		
		// Lesen
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person inputText = (Person) ois.readObject();
		Person inputText2 = (Person) ois.readObject();
		System.out.println(inputText);
		System.out.println(inputText2);
		ois.close();
	}

}
