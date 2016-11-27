package entities.stats;

import entities.actors.BasketballPlayer;
import inputs.Move;

public abstract class MoveSourceStat extends MoveStat {

	public MoveSourceStat(BasketballPlayer player) {
		super(player);
	}

	@Override
	public void evaluate(Move m, Move m2) throws WrongUsageOfStatException {
		if (!player.equals(m.getSource()))
			return;
		computeValue(m, m2);
	}

}
