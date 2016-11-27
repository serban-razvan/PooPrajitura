package entities.stats;

import entities.actors.BasketballPlayer;
import inputs.Move;
import inputs.StatInput;

public abstract class MoveStat extends Stat {

	public MoveStat(BasketballPlayer player) {
		super(player);
	}

	@Override
	public void evaluate(StatInput s, StatInput s2) throws WrongUsageOfStatException {
		if (!(s instanceof Move) || (s2 != null && !(s2 instanceof Move)))
			return;
		evaluate((Move) s, (Move) s2);
	}

	abstract public void evaluate(Move m, Move m2) throws WrongUsageOfStatException;

	abstract public void computeValue(Move m, Move m2);

}
