package org.campus02.teamliga;

import java.util.Comparator;

public class Team implements Comparable<Team>  {
	private String name;
	int countWon;
	int countLost;
	int countDraw;
	int goalsScored;
	int goalsGot;
	int points;
	int playedRounds;
	
	public Team (String name)
	{
		this.name = name;
		countWon = 0;
		countLost = 0;
		countDraw = 0;
		goalsScored  = 0;
		goalsGot = 0;
		points = 0;
		playedRounds = 0;
	}
	public String getName()
	{
		return this.name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countDraw;
		result = prime * result + countLost;
		result = prime * result + countWon;
		result = prime * result + goalsGot;
		result = prime * result + goalsScored;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + playedRounds;
		result = prime * result + points;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "Team [name=" + name + ", countWon=" + countWon + ", countLost=" + countLost + ", countDraw=" + countDraw
				+ ", goalsScored=" + goalsScored + ", goalsGot=" + goalsGot + ", points=" + points + ", playedRounds="
				+ playedRounds + "]";
	}
	@Override
	public int compareTo(Team o) {
		int points = 0;
		
		points = (this.points < o.points) ? 1 :
			 (this.points > o.points) ? -1 : 0;

		if (points != 0)
			return points;
		
		if ((this.goalsScored - this.goalsGot) 
			< (o.goalsScored - o.goalsGot))
			return 1;
		if ((this.goalsScored - this.goalsGot) 
				> (o.goalsScored - o.goalsGot))
			return -1;
		
		return 0;
		
	}

	public void gameFinished(int goalsScored, int goalsGot) throws GoalsMustbePositiveException
	{
		if (goalsGot < 0 || goalsScored < 0)
			throw new GoalsMustbePositiveException();
		
		this.playedRounds++;
		this.goalsGot += goalsGot;
		this.goalsScored += goalsScored;
		
		if (goalsScored > goalsGot)
		{
			this.points += 3;
			this.countWon++;
		} 
		else if (goalsScored < goalsGot)
		{
			
			this.countLost ++;
		}
		else
		{
			this.points += 1;
			this.countDraw++;
		}
	}

	
}
