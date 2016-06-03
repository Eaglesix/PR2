package org.campus02.threading04;

public class ThreadConsolePrinter extends Thread {

	private char identifier;
	public ThreadConsolePrinter(char c)
	{
		identifier = c;
	}
	
	@Override
	public void run()
	{
		int i = 0;
		while(true)
		{
			i++;
			System.out.println(i + " [ identifier: " + identifier + "]");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
