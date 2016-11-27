package entities.stats;

import entities.actors.BasketballPlayer;
import entities.actors.Hoop;
import inputs.Move;

public class Assist extends MoveSourceStat {

	public Assist(BasketballPlayer player) {
		super(player);
		name = "AST";
	}

	@Override
	public void computeValue(Move m, Move m2) {
		if (m2 == null)
			return;
		if (m2.getSource() instanceof BasketballPlayer && m2.getDestination() instanceof Hoop) {
			BasketballPlayer p1 = (BasketballPlayer) m.getSource();
			BasketballPlayer p2 = (BasketballPlayer) m2.getSource();
			Hoop h = (Hoop) m2.getDestination();
			if (p1.getTeam().equals(p2.getTeam()) && !p2.getTeam().equals(h.getTeam())) {
				value++;
			}
		}
	}

}
