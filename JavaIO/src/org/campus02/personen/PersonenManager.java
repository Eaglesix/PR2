package org.campus02.personen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonenManager {

	private ArrayList<Person> personen = new ArrayList<>();
	
	public void load(String path)
			throws PersonenManagerException
	{
		File file = new File(path);
		
		try
		(FileReader fr = new FileReader(file);
		 BufferedReader br = new BufferedReader(fr)
				)
		{
			String inputLine;
			while ((inputLine = br.readLine())!= null)
			{
				// inputLine == Zeile für Zeile aus Datei
				String[] columns = inputLine.split(",");
				if (columns.length != 3)
					throw new PersonenManagerException("Ungültige Zeile: " + inputLine);
				
				Person p = new Person(columns[0],
						columns[1], columns[2]);
							
				personen.add(p);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new PersonenManagerException(e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			throw new PersonenManagerException(e1);
		}
		
		
	}

	public ArrayList<Person> getPersonen() {
		return personen;
	}
	
	
}
