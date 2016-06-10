package org.campus02.urlaub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UrlaubManager {

	private final String pfad;
	
	public UrlaubManager(String pfad) {
		this.pfad = pfad;
	}
	
	public ArrayList<Urlaub> load(String mitarbeiter) 
			throws DataFileException
	{
		int counter = 0;
		ArrayList<Urlaub> urlaube = new ArrayList<Urlaub>();
		File f = new File(pfad);
		
		try( FileReader reader = new FileReader(f);
				BufferedReader br = new BufferedReader(reader);	)
		{
			String line;
			while((line = br.readLine())!= null)
			{
				counter++;
				String[] array = line.split(",");
				if (array[1].equals(mitarbeiter))				
				{
					Urlaub u = new Urlaub(Integer.parseInt(array[0]),
						array[1], array[2], array[3]);
					urlaube.add(u);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DataFileException("Fehler in Zeile: " + counter, 
					e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DataFileException("Fehler in Zeile: " + counter,
					e);
		}
		
		Collections.sort(urlaube, new UrlaubComparator());
		
		return urlaube;
	}

}
