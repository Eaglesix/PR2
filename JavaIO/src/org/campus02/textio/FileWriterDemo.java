package org.campus02.textio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f = new File("D:\\temp\\file-write.txt");
		FileWriter fw = new FileWriter(f);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("First Line");
		pw.println("Second Line3");
		
		pw.flush();
		pw.close();
		
		
		
	}

}
