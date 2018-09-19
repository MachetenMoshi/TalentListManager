package tasks;

import javafx.concurrent.Task;
import objects.Player;
import services.SoFifaService;

public class PlayerLoadingTask extends Task<Player> {

	private String id;

	public PlayerLoadingTask(String id) {
		this.id = id;
	}

	@Override
	protected Player call() throws Exception {
		SoFifaService soFifaService = new SoFifaService();
		return soFifaService.loadPlayer(id);
	}

}
