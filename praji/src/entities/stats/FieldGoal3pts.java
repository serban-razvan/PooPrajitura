package entities.stats;

import entities.actors.BasketballPlayer;
import entities.actors.Hoop;
import inputs.Move;

public class FieldGoal3pts extends MoveSourceStat {

	public FieldGoal3pts(BasketballPlayer player) {
		super(player);
		name = "FG3";
	}

	@Override
	public void computeValue(Move m, Move m2) {
		if (m.getDestination() instanceof Hoop) {
			if (m.getDistance() >= 7) {
				value++;
			}
		}
	}

}
