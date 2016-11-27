package entities.stats;

import entities.actors.BasketballPlayer;
import entities.actors.Hoop;
import inputs.Move;

public class FieldGoal2pts extends MoveSourceStat {

	public FieldGoal2pts(BasketballPlayer player) {
		super(player);
		name = "FG2";
	}

	@Override
	public void computeValue(Move m, Move m2) {
		if (m.getDestination() instanceof Hoop) {
			if (m.getDistance() < 7) {
				value++;
			}
		}
	}

}
