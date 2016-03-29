package org.campus02.teamliga;

import java.util.Comparator;

public class AlphapeticComparator 
implements Comparator<Team> {

	@Override
	public int compare(Team o1, Team o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

	

}
