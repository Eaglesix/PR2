package rekursion;

import java.io.File;

public class RekursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("D:\\temp");
		//file.isDirectory()
		System.out.println(file.listFiles().length);
		print(file, "");
		file.getName();
		
		System.out.println("Total Size: " + getSize(file));
	}
	
	public static void print(File f, String prefix)
	{
//		System.out.println(prefix + f.getName());
		for (File file : f.listFiles())
		{
			if (file.isDirectory())
			{
				System.out.println(prefix + "+" + file.getName());
				print(file, prefix + "  ");
			}
			else
			{
				System.out.println(prefix + "-" + file.getName());					
			}
		}
	}
	
	public static long getSize(File f)
	{
		long size = f.length();
		if (!f.isDirectory())
			return size;
		
		for (File file : f.listFiles())
		{
			size += getSize(file);	
		}
		return size;
	}

}
