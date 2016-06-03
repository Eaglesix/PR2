package org.campus02.threading03;

public class PrimApp {

	public static void main(String[] args) throws InterruptedException  {

		PrimValidation p1 = new PrimValidation(1930000067 );
		PrimValidation p2 = new PrimValidation(1999990019);
		PrimValidation p3 = new PrimValidation(1999990119);

		
		Thread th1 = new Thread(p1);
		Thread th2 = new Thread(p2);
		Thread th3 = new Thread(p3);
		
		th1.start();th2.start();th3.start();
		
		System.out.println("waiting for threads");
		try {
			th1.join();
			th2.join();
			th3.join();
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
