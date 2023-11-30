package ngs.ui.console;

import ngs.service.ClubService;
import ngs.service.ServiceLogicLifeCycler;

public class ClubSubConsole {

	private ClubService clubservice;

	public ClubSubConsole() {
		this.clubservice = ServiceLogicLifeCycler.getUniuqeInstance().getClubService();

	}
}
