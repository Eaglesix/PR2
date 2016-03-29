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
		if (findTeam(name) != null)
			throw new TeamAlreadyExistsException();

		
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
	
	private Team findTeam(String name)
	{
		for (Team team : teams) {
			if (team.getName().equals(name))
				return team;
		}
		return null;
	}
	
	public void newGame(String teamA, int goalsA, 
			String teamB, int goalsB) throws TeamNotFoundException, LigaException
	{
		Team a = null;// = findTeam(teamA);
		Team b = null;// = findTeam(teamB);
		
		for (Team team : teams) {
			if (team.getName().equals(teamA))
				a = team;
			if (team.getName().equals(teamB))
				b = team;
			
			if (a != null && b != null)
				break;
		}
		
		if  (a == null || b == null)
			throw new TeamNotFoundException();
		
		try {
			a.gameFinished(goalsA, goalsB);
			b.gameFinished(goalsB, goalsA);
		} catch (GoalsMustbePositiveException e) {
			throw new LigaException();
		}
	}

	@Override
	public String toString() {
		return "Liga [teams=" + teams + ", name=" + name + "]";
	}
}
