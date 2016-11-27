package entities.stats;

import entities.actors.BasketballPlayer;
import inputs.StatInput;

public abstract class Stat implements Comparable<Stat> {

	String name;
	Integer value;
	BasketballPlayer player;

	public Stat(BasketballPlayer player) {
		this.name = "?";
		this.value = new Integer(0);
		this.player = player;
	}

	@Override
	public String toString() {
		return name + ":" + value + "  ";
	}

	abstract public void evaluate(StatInput s, StatInput s2) throws WrongUsageOfStatException;

	@Override
	public int compareTo(Stat o) {
		return o.value - value;
	}
}
