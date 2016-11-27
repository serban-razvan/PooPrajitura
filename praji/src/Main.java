import java.util.List;

import dataReceiver.DataReceiver;
import dataReceiver.MockDataReceiver;
import dataSender.DataSender;
import dataSender.MockDataSender;
import engine.GameplayAnalyzer;
import engine.StatEngine;
import entities.PlayerAchievement;
import entities.PlayerUpdate;
import inputs.GameSummary;

public class Main {

	public static void main(String[] args) {
		DataReceiver dr = new MockDataReceiver();
		GameSummary gameSummary = dr.receive();

		StatEngine se = new StatEngine();
		List<PlayerUpdate> profileUpdates = se.compute(gameSummary);

		GameplayAnalyzer ga = new GameplayAnalyzer();
		List<PlayerAchievement> playerAchievements = ga.compute(gameSummary);

		DataSender ds = new MockDataSender();
		ds.persist(profileUpdates);
		ds.persist(playerAchievements);

	}

}
