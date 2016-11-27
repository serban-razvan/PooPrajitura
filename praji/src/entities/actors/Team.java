package entities.actors;

public class Team {

	private String acronym;

	public Team(String acronym) {
		this.acronym = acronym;
	}

	@Override
	public String toString() {
		return acronym;
	}

}
