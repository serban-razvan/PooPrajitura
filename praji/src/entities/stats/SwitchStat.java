package entities.stats;

import entities.actors.BasketballPlayer;
import inputs.StatInput;
import inputs.Switch;

public abstract class SwitchStat extends Stat {

	public SwitchStat(BasketballPlayer player) {
		super(player);
	}

	@Override
	public void evaluate(StatInput s, StatInput s2) throws WrongUsageOfStatException {
		if (!(s instanceof Switch) || (s2 != null && !(s2 instanceof Switch)))
			return;
		if (!player.equals(((Switch) s).getPlayer()))
			throw new WrongUsageOfStatException();
		computeValue((Switch) s);
	}

	abstract public void computeValue(Switch s);

}
