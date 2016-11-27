package engine;

import java.util.LinkedList;
import java.util.List;

import entities.PlayerAchievement;
import entities.PlayerAchievement.PlayerAchievementType;
import entities.actors.BasketballPlayer;
import inputs.GameSummary;
import inputs.Move;
import inputs.Switch;
import inputs.Switch.SwitchType;
import util.CountingGraph;
import util.MaximumElementsInGraphException;

public class GameplayAnalyzer {

	public List<PlayerAchievement> compute(GameSummary gameSummary) {

		// build the graph
		int teamASize = gameSummary.getTeamAPlayers().size();
		int teamBSize = gameSummary.getTeamBPlayers().size();
		CountingGraph<BasketballPlayer> g = new CountingGraph<BasketballPlayer>(teamASize + teamBSize);
		CountingGraph<BasketballPlayer> gModif = new CountingGraph<BasketballPlayer>(teamASize + teamBSize);

		for (Switch s : gameSummary.getSwitches()) {
			if (s.getType() == SwitchType.IN) {
				try {
					g.addVertice(s.getPlayer());
					gModif.addVertice(s.getPlayer());
				} catch (MaximumElementsInGraphException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		for (Move m : gameSummary.getMoves()) {
			if (m.getSource() instanceof BasketballPlayer && m.getDestination() instanceof BasketballPlayer) {
				BasketballPlayer srcPlayer = (BasketballPlayer) m.getSource();
				BasketballPlayer dstPlayer = (BasketballPlayer) m.getDestination();
				if (srcPlayer.getTeam().equals(dstPlayer.getTeam())) {
					g.addEdge(srcPlayer, dstPlayer);
				}
				else{
					//oposing teams, what we are interested in
					gModif.addEdgeSpecial(srcPlayer,dstPlayer);
				}
			}
		}

		// extract necessary information
		List<PlayerAchievement> pa = new LinkedList<PlayerAchievement>();

		// Best pass receiver
		pa.add(new PlayerAchievement(PlayerAchievementType.BEST_PASS_RECEIVER, g.getNodeWithHighestInDegree()));

		// Best pass sender
		pa.add(new PlayerAchievement(PlayerAchievementType.BEST_PASS_SENDER, g.getNodeWithHighestOutDegree()));

		// Best ball retriever?
		pa.add(new PlayerAchievement(PlayerAchievementType.BEST_INTERCEPTER, gModif.getNodeWithHighestDegreeSpecial()));
		// Worst ball looser?
		pa.add(new PlayerAchievement(PlayerAchievementType.BEST_BALL_LOSER, gModif.getNodeWithLowestDegreeSpecial()));

		
		return pa;

	}

}
