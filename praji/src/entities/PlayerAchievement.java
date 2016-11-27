package entities;

import entities.actors.BasketballPlayer;

public class PlayerAchievement implements Comparable<PlayerAchievement> {

	public enum PlayerAchievementType implements Comparable<PlayerAchievementType> {
		BEST_PASS_SENDER(1), BEST_PASS_RECEIVER(2),
		BEST_INTERCEPTER(3), BEST_BALL_LOSER(4);

		int prio;

		PlayerAchievementType(int prio) {
			this.prio = prio;
		}
	}

	BasketballPlayer player;
	PlayerAchievementType type;

	public PlayerAchievement(PlayerAchievementType type, BasketballPlayer player) {
		this.type = type;
		this.player = player;
	}

	@Override
	public String toString() {
		return "PlayerAchievement [player=" + player + ", type=" + type + "]";
	}

	@Override
	public int compareTo(PlayerAchievement o) {
		return type.prio - o.type.prio;
	}

}
