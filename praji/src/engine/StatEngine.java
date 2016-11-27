package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.PlayerUpdate;
import entities.actors.BasketballPlayer;
import inputs.GameSummary;
import inputs.Move;
import inputs.Switch;

public class StatEngine {

	public List<PlayerUpdate> compute(GameSummary gameSummary) {

		Map<BasketballPlayer, PlayerUpdate> pu = new HashMap<BasketballPlayer, PlayerUpdate>();

		// initialize profile updates
		for (BasketballPlayer p : gameSummary.getTeamAPlayers().values()) {
			pu.put(p, new PlayerUpdate(p));
		}
		for (BasketballPlayer p : gameSummary.getTeamBPlayers().values()) {
			pu.put(p, new PlayerUpdate(p));
		}

		// process switches
		for (Switch s : gameSummary.getSwitches()) {
			pu.get(s.getPlayer()).evaluate(s, null);
		}

		// process moves
		for (int i = 0; i < gameSummary.getMoves().size(); i++) {
			Move m = gameSummary.getMoves().get(i);
			Move m2 = null;
			if (i < gameSummary.getMoves().size() - 1) {
				m2 = gameSummary.getMoves().get(i + 1);
			}
			if (m.getSource() instanceof BasketballPlayer) {
				pu.get(m.getSource()).evaluate(m, m2);
			}
			if (m.getDestination() instanceof BasketballPlayer) {
				pu.get(m.getDestination()).evaluate(m, m2);
			}
		}

		return new ArrayList<PlayerUpdate>(pu.values());

	}

}
