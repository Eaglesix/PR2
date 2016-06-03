package org.campus02.threading01;

public class ThreadConsolePrinter extends Thread {

	private char identifier;
	public ThreadConsolePrinter(char c)
	{
		identifier = c;
	}
	
	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println(i + " [ identifier: " + identifier + "]");
		
			Thread.yield();
			/*try {
				
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
}
