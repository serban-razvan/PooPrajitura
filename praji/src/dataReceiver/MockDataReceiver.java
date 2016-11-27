package dataReceiver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.actors.BasketballPlayer;
import entities.actors.Hoop;
import entities.actors.Team;
import inputs.GameSummary;
import inputs.Move;
import inputs.Switch;

public class MockDataReceiver implements DataReceiver {

	@Override
	public GameSummary receive() {

		// Generate teams
		Team a = new Team("a");
		Team b = new Team("b");

		// Generate players
		Map<Integer, BasketballPlayer> teamAPlayers = new HashMap<Integer, BasketballPlayer>();
		for (int i = 1; i <= 10; i++) {
			teamAPlayers.put(i, new BasketballPlayer(i, a));
		}
		Map<Integer, BasketballPlayer> teamBPlayers = new HashMap<Integer, BasketballPlayer>();
		for (int i = 1; i <= 10; i++) {
			teamBPlayers.put(i, new BasketballPlayer(i, b));
		}

		// Generate other actors
		Hoop ha = new Hoop(a);

		// Generate switches
		List<Switch> switches = new ArrayList<Switch>();
		switches.add(new Switch(teamAPlayers.get(1), Switch.SwitchType.IN));
		switches.add(new Switch(teamAPlayers.get(2), Switch.SwitchType.IN));
		switches.add(new Switch(teamAPlayers.get(3), Switch.SwitchType.IN));
		switches.add(new Switch(teamAPlayers.get(4), Switch.SwitchType.IN));
		switches.add(new Switch(teamAPlayers.get(5), Switch.SwitchType.IN));
		switches.add(new Switch(teamBPlayers.get(1), Switch.SwitchType.IN));
		switches.add(new Switch(teamBPlayers.get(2), Switch.SwitchType.IN));
		switches.add(new Switch(teamBPlayers.get(3), Switch.SwitchType.IN));
		switches.add(new Switch(teamBPlayers.get(4), Switch.SwitchType.IN));
		switches.add(new Switch(teamBPlayers.get(5), Switch.SwitchType.IN));

		// Generate moves
		List<Move> moves = new ArrayList<Move>();
		moves.add(new Move(23, teamAPlayers.get(1), teamAPlayers.get(3), 5));
		moves.add(new Move(53, teamAPlayers.get(3), teamAPlayers.get(2), 3));
		moves.add(new Move(53, teamAPlayers.get(2), teamAPlayers.get(3), 3));
		moves.add(new Move(53, teamAPlayers.get(3), teamAPlayers.get(4), 3));
		moves.add(new Move(81, teamAPlayers.get(4), teamBPlayers.get(3), 1));
		moves.add(new Move(81, teamBPlayers.get(3), teamAPlayers.get(1), 1));
		moves.add(new Move(81, teamAPlayers.get(1), teamAPlayers.get(3), 1));
		moves.add(new Move(81, teamAPlayers.get(3), teamBPlayers.get(3), 1));
		moves.add(new Move(85, teamBPlayers.get(3), teamBPlayers.get(1), 10));
		moves.add(new Move(94, teamBPlayers.get(1), teamBPlayers.get(2), 6));
		moves.add(new Move(95, teamBPlayers.get(2), ha, 7));

		return new GameSummary(teamAPlayers, teamBPlayers, switches, moves);
	}

}
