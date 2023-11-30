package ngs.service;

import java.util.Arrays;

import ngs.etity.TravelClub;

public class ClubServiceLogic implements ClubService {
	private TravelClub[] clubs;
	private int index;

	public ClubServiceLogic() {
		this.clubs = new TravelClub[10];
		this.index = 0;
	}

	@Override
	public void register(TravelClub travelclub) {
		clubs[index] = travelclub;
		index++;
	}

	@Override
	public TravelClub[] findAll() {
		return Arrays.copyOfRange(clubs, 0, index);

	}

	@Override
	public TravelClub findByID(String clubId) {
		TravelClub[] createclubs = Arrays.copyOfRange(clubs, 0, index);
		TravelClub foundclub = null;
		for (TravelClub club : createclubs) {
			if (clubId.equals(club.getId())) {
				foundclub = club;
				break;
			}
		}
		return foundclub;
	}

	@Override
	public TravelClub[] findByName(String clubName) {
		TravelClub[] createclubs = Arrays.copyOfRange(clubs, 0, index);
		TravelClub[] foundclubs = new TravelClub[createclubs.length];
		int subIndex = 0;
		for (TravelClub club : createclubs) {
			if (clubName.equals(club.getClubName())) {
				foundclubs[subIndex] = club;
				subIndex++;
			}
		}
		return Arrays.copyOfRange(foundclubs, 0, subIndex);

	}

	@Override
	public void modify(TravelClub modifyClub) {
		int foundIndex = 0;
		for (int i = 0; i < clubs.length; i++) {
			if (clubs[i].getId().equals(modifyClub.getId())) {
				foundIndex = 1;
				break;
			}
		}
		this.clubs[foundIndex] = modifyClub;
	}

	@Override
	public void remove(String clubId) {
		int foundIndex = 0;
		for (int i = 0; i < this.index; i++) {		
			if (clubId.equals(clubs[i].getId())) {
				foundIndex = i;
				break;
			}
		}
			
		for (int i  = foundIndex; i < index ; i++) {
			clubs[i] = clubs[i+1];
		}

		this.index--;
	}

}
