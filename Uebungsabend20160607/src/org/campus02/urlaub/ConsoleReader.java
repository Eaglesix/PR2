package org.campus02.urlaub;

import java.util.Scanner;

public class ConsoleReader implements Runnable {

	public boolean Stop;
	@Override
	public void run() {
		
		Stop = false;
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			if (sc.nextLine().equals("exit"))
			{
				System.out.println("stopped via exit");
				Stop = true;
				break;
			}
		}

	}

}
