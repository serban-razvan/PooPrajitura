package entities.stats;

import entities.actors.BasketballPlayer;
import inputs.Switch;

public class GamesStarted extends SwitchStat {

	public GamesStarted(BasketballPlayer player) {
		super(player);
		name = "GST";
	}

	@Override
	public void computeValue(Switch s) {
		value = 1;
	}

}
