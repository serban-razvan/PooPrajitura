package entities;

import java.util.LinkedList;
import java.util.List;

import entities.actors.BasketballPlayer;
import entities.stats.Assist;
import entities.stats.FieldGoal2pts;
import entities.stats.FieldGoal3pts;
import entities.stats.GamesStarted;
import entities.stats.Stat;
import entities.stats.Steal;
import entities.stats.WrongUsageOfStatException;
import inputs.StatInput;

public class PlayerUpdate implements Comparable<PlayerUpdate> {

	BasketballPlayer player;
	List<Stat> stats;

	public PlayerUpdate(BasketballPlayer player) {
		this.player = player;
		stats = new LinkedList<Stat>();
		stats.add(new GamesStarted(player));
		stats.add(new FieldGoal3pts(player));
		stats.add(new FieldGoal2pts(player));
		stats.add(new Assist(player));
		stats.add(new Steal(player));
	}

	public void evaluate(StatInput s, StatInput s2) {
		for (Stat stat : stats) {
			try {
				stat.evaluate(s, s2);
			} catch (WrongUsageOfStatException e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public String toString() {
		String res = (player + "      ").substring(0, 6) + "|";
		for (Stat s : stats) {
			res += s;
		}
		return res;
	}

	@Override
	public int compareTo(PlayerUpdate o) {
		for (int i = 0; i < stats.size(); i++) {
			int comp = stats.get(i).compareTo(o.stats.get(i));
			if (comp != 0)
				return comp;
		}
		return 0;
	}

}
