package tasks;

import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Task;
import objects.Player;
import services.SoFifaService;

public class PlayerUpdateTask extends Task<List<Player>> {

	private List<Player> players;

	public PlayerUpdateTask(List<Player> players) {
		this.players = players;
	}

	@Override
	protected List<Player> call() throws Exception {
		SoFifaService soFifaService = new SoFifaService();
		List<Player> updatedPlayers = new ArrayList<>();
		for (Player player : players) {
			try {
				Player updatedPlayer = soFifaService.loadPlayer(player.getInformation().getId());
				if (updatedPlayer != null)
					updatedPlayer.getInformation().setComment(player.getInformation().getComment());
				updatedPlayers.add(updatedPlayer);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return updatedPlayers;
	}

}
