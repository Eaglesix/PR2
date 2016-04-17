package org.campus02.file;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {

		File dir = new File("D:\\temp");
		
		for (File file : dir.listFiles()) {
			System.out.println(file.getName() 
					+ " - Size: " + file.length());
		}

	}

}
