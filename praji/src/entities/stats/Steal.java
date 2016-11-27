package entities.stats;

import entities.actors.BasketballPlayer;
import inputs.Move;

public class Steal extends MoveDestinationStat {

	public Steal(BasketballPlayer player) {
		super(player);
		name = "STL";
	}

	@Override
	public void computeValue(Move m, Move m2) {
		BasketballPlayer otherPlayer = (BasketballPlayer) m.getSource();
		if (!player.getTeam().equals(otherPlayer.getTeam())) {
			value++;
		}

	}

}
