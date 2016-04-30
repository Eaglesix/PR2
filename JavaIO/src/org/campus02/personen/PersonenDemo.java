package org.campus02.personen;

public class PersonenDemo {

	public static void main(String[] args) {

		PersonenManager manager = new PersonenManager();
		
		try {
			manager.load("D:\\temp\\personen.txt");
		} catch (PersonenManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Person p : manager.getPersonen())
		{
			System.out.println(p);
		}

	}

}
