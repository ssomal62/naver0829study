package ngs.service;

public class ServiceLogicLifeCycler {
	
	private static ServiceLogicLifeCycler uniqueInstance;
	
	private ClubService clubservice;
	
	private ServiceLogicLifeCycler() {
		this.clubservice = new ClubServiceLogic();
	}
	
	public static ServiceLogicLifeCycler getUniuqeInstance() {
		if(uniqueInstance== null) {
			uniqueInstance = new ServiceLogicLifeCycler();
		}
		return uniqueInstance;
	}
	
	public ClubService getClubService() {

		return this.clubservice;
	}
	

}
