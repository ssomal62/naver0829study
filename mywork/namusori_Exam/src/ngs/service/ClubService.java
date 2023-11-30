package ngs.service;

import ngs.etity.TravelClub;

public interface ClubService {

	
	public void register(TravelClub travelclub);
	
	public TravelClub[] findAll();
	
	public TravelClub findByID(String clubId);
	
	public TravelClub[] findByName(String clubName);
	
	public void modify(TravelClub modifyClub);
	
	public void remove(String clubId);

}
