package org.campus02.threading06;

public class Counter implements Runnable {

	public static int Counter; // statisches Attribute, welches geteilt wird!
	private static Object lock = new Object();
	private static String lockB = "";
	@Override
	public void run() {

		for (int i = 0; i < 1_000_000; i++) {
			Increase();
		}
	}

	private void Increase() {
		synchronized (lock) {
			Counter++;
		}
		
		synchronized (lockB) {
			Counter++;
		}
		
	}
	
	
}
