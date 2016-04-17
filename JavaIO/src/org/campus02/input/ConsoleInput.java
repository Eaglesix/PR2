package org.campus02.input;

import java.io.IOException;

public class ConsoleInput {

	public static void main(String[] args) 
			throws IOException {
		int byteRead = System.in.read();
		while (byteRead != -1)
		{
			char[] ch = Character.toChars(byteRead);
			System.out.print(ch[0]);
			
			if (ch[0] == 'x')
				break;
			
			byteRead = System.in.read();
		}

	}

}
