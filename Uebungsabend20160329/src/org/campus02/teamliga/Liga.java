package org.campus02.teamliga;

import java.util.ArrayList;
import java.util.Collections;

public class Liga {
	private ArrayList<Team> teams 
		= new ArrayList<>();
	private String name;
	
	public Liga(String name)
	{
		this.name = name;
		//this.teams = new ArrayList<>();

	}
	
	public void add(String name) 
			throws TeamAlreadyExistsException
	{
		for (Team team : teams) {
			if (team.getName().equals(name))
			{
				// FEHLERFALL
				throw new TeamAlreadyExistsException();
			}
		}

		
		this.teams.add(new Team(name));
	}
	
	public ArrayList<Team> getTeamsByPoints()
	{
		Collections.sort(teams);
		return teams;
	}
	
	public ArrayList<Team> getAllTeams()
	{
		//Collections.sort(teams, new AlphapeticComparator());		
		teams.sort(new AlphapeticComparator());
		
		return teams;
	}

	@Override
	public String toString() {
		return "Liga [teams=" + teams + ", name=" + name + "]";
	}
}
