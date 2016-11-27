package entities.stats;

import entities.actors.BasketballPlayer;
import inputs.Move;

public abstract class MoveDestinationStat extends MoveStat {

	public MoveDestinationStat(BasketballPlayer player) {
		super(player);
	}

	@Override
	public void evaluate(Move m, Move m2) throws WrongUsageOfStatException {
		if (!player.equals(m.getDestination()))
			return;
		computeValue(m, m2);
	}

}
