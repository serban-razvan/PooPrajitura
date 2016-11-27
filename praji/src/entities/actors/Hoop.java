package entities.actors;

public class Hoop implements Actor {

	Team team;

	public Hoop(Team team) {
		super();
		this.team = team;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
