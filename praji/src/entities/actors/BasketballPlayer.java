package entities.actors;

public class BasketballPlayer implements Actor {

	Integer no;
	Team team;

	public BasketballPlayer(Integer no, Team team) {
		super();
		this.no = no;
		this.team = team;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return team + "(" + no + ")";
	}

}
