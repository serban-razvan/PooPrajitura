package inputs;

import entities.actors.BasketballPlayer;

public class Switch implements StatInput {

	public enum SwitchType {
		IN, OUT
	}

	BasketballPlayer player;
	SwitchType type;

	public Switch(BasketballPlayer player, SwitchType type) {
		super();
		this.player = player;
		this.type = type;
	}

	public BasketballPlayer getPlayer() {
		return player;
	}

	public void setPlayer(BasketballPlayer player) {
		this.player = player;
	}

	public SwitchType getType() {
		return type;
	}

	public void setType(SwitchType type) {
		this.type = type;
	}

}
