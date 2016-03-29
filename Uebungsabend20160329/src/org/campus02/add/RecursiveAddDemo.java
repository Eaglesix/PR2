package org.campus02.add;

public class RecursiveAddDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(3, 5));
		System.out.println(add1(3, 5));
		
		System.out.println(mult(0, 5));
	}
	
	public static int add(int a, int b)
	{
		if (b == 1)
			return a + 1;
		return add(a + 1, b - 1);
	}

	public static int add1(int a, int b)
	{
		if (b == 0)
			return a;
		return add1(a + 1, b - 1);
	}
	
	public static int mult(int x, int y)
	{
		if (x == 0 || y == 0)
			return 0;
		
		if (y == 1)
			return x;
		
		return add(x, mult(x, y - 1));
	}
	
}
