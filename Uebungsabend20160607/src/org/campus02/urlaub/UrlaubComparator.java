package org.campus02.urlaub;

import java.util.Comparator;

public class UrlaubComparator implements Comparator<Urlaub> {

	@Override
	public int compare(Urlaub arg0, Urlaub arg1) {

		int erg = arg0.getVon().compareTo(arg1.getVon());
		if (erg == 0)
		{
			return arg0.getMitarbeiter().compareTo
					(arg1.getMitarbeiter());
			/*if (arg0.getId() < arg1.getId())
				return -1;

			if (arg0.getId() > arg1.getId())
				return 1;
			
			return 0;*/
		}


		return erg;
	}

}
