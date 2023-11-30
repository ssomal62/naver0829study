package ngs.ui.console;

import ngs.etity.TravelClub;
import ngs.service.ClubService;
import ngs.service.ClubServiceLogic;
import ngs.service.ServiceLogicLifeCycler;
import ngs.util.ConsoleUtil;

public class ClubConsole {
	private ConsoleUtil util;
	private ClubService clubservice;

	public ClubConsole() {
		this.util = new ConsoleUtil();
		this.clubservice = ServiceLogicLifeCycler.getUniuqeInstance().getClubService();

	}

	public void register() {
		while (true) {
			System.out.println("[새클럽 등록]");
			String clubName = util.getValueOf("Club Name");
			if (clubName.equals("0"))
				return;

			String intro = util.getValueOf("Club Intro");
			if (intro.equals("0"))
				return;
			TravelClub newClub = new TravelClub(clubName, intro);
			clubservice.register(newClub);

			System.out.println(newClub.toString());
			System.out.println();
		}
	}

	public void FindAll() {
		TravelClub[] foundclubs = clubservice.findAll();

		if (foundclubs.length == 0) {
			System.out.println("등록된 클럽이 하나도 없습니다.");
			return;
		}
		for (TravelClub club : foundclubs) {
			System.out.println(club.toString());
		}
	}

	public void FindbyId() {
		TravelClub foundclub = null;
		while (true) {

			String clubId = util.getValueOf("Culb ID (Menu : 0)");
			if (clubId.equals("0")) {
				break;
			}

			foundclub = clubservice.findByID(clubId);

			if (foundclub != null) {
				System.out.println(foundclub);
			} else {

				System.out.println("[" + clubId + "] 클럽을 찾을 수 없습니다.");
			}
		}
	}

	public void FindbyName() {
		TravelClub[] foundclubs;
		while (true) {
			String clubName = util.getValueOf("Culb Name (Menu : 0)");
			if (clubName.equals("0")) {
				break;
			}

			foundclubs = clubservice.findByName(clubName);

			if (foundclubs != null && foundclubs.length != 0) {
				for (TravelClub club : foundclubs) {
					System.out.println(club);
				}
			} else {
				System.out.println("[" + clubName + "] 클럽을 찾을 수 없습니다.");
			}

		}
	}

	private TravelClub findbyOne() {
		TravelClub foundclub = null;
		while (true) {
			String clubId = util.getValueOf("Culb ID (Menu : 0)");
			if (clubId.equals("0")) {
				break;
			}

			foundclub = clubservice.findByID(clubId);

			if (foundclub != null) {
				break;
			} else {
				System.out.println("[" + clubId + "] 클럽을 찾을 수 없습니다.");
			}
		}
		return foundclub;
	}

	public void modify() {
		TravelClub targetClub = findbyOne();
		if(targetClub == null) {
			return;
		}
		String newName = util.getValueOf("New Culb ID (Menu : 0, Enter :no change )");
		if (newName.equals("0")) {
			return;
		}

		if (!newName.isEmpty()) {
			targetClub.setClubName(newName);
		}

		String newIntro = util.getValueOf("New Culb Intro (Menu : 0 , Enter :no change ))");
		if (!newIntro.isEmpty()) {
			targetClub.setIntro(newIntro);
		}
		
		System.out.println(targetClub);

		//clubservice.modify(targetClub);// 없어도 동작함...
	}

	public void remove() {
		TravelClub targetClub = findbyOne();
		if(targetClub == null) {
			return;
		}
		String confirmStr = util.getValueOf("Remove ["+ targetClub.getClubName()+ "] club? (Y : yes , N : no ))");
		
		String targetId = targetClub.getId();
		if (confirmStr.toLowerCase().equals("y")||confirmStr.toLowerCase().equals("yes")) {
			System.out.println("Remove Completed ---> " + targetClub.getClubName());
			clubservice.remove(targetId);

		}else {
			System.out.println("Remove cancelled, your club is safe!!!");
		}
		
	}

}
