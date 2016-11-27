package inputs;

import java.util.List;
import java.util.Map;

import entities.actors.BasketballPlayer;

public class GameSummary {
	Map<Integer, BasketballPlayer> teamAPlayers;
	Map<Integer, BasketballPlayer> teamBPlayers;
	List<Switch> switches;
	List<Move> moves;

	public GameSummary(Map<Integer, BasketballPlayer> teamAPlayers, Map<Integer, BasketballPlayer> teamBPlayers,
			List<Switch> switches, List<Move> moves) {
		super();
		this.teamAPlayers = teamAPlayers;
		this.teamBPlayers = teamBPlayers;
		this.switches = switches;
		this.moves = moves;
	}

	public Map<Integer, BasketballPlayer> getTeamAPlayers() {
		return teamAPlayers;
	}

	public void setTeamAPlayers(Map<Integer, BasketballPlayer> teamAPlayers) {
		this.teamAPlayers = teamAPlayers;
	}

	public Map<Integer, BasketballPlayer> getTeamBPlayers() {
		return teamBPlayers;
	}

	public void setTeamBPlayers(Map<Integer, BasketballPlayer> teamBPlayers) {
		this.teamBPlayers = teamBPlayers;
	}

	public List<Switch> getSwitches() {
		return switches;
	}

	public void setSwitches(List<Switch> switches) {
		this.switches = switches;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

}
