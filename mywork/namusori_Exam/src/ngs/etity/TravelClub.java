package ngs.etity;

import java.util.UUID;

import ngs.util.DateUtil;

public class TravelClub {
	
	private static final int MINIMUM_NAME_LENGTH = 3;
	private static final int MINIMUM_INTRO_LENGTH = 5;
	
	//필드
	private String id;
	private String clubName;
	private String intro;
	private String foundationDay;
	

	public TravelClub() {
		this.id = UUID.randomUUID().toString();
	}

	public TravelClub (String clubName, String intro) {
		this();
		setClubName(clubName); 	//this.clubName = clubName;에서 업그레이드
		setIntro(intro);
		this.foundationDay = DateUtil.today();
	}
	
	//Method
	//setter
	public void setClubName(String clubName) {
		if(clubName.length() < MINIMUM_NAME_LENGTH) {
			System.out.println("이름 길이 에러메세지 // 최대 길이 : " + MINIMUM_NAME_LENGTH);
			return;
		}
		this.clubName = clubName;
	}
	
	//getter
	public String getClubName() {
		return this.clubName;
	}
	
	public void setIntro(String intro) {
		if (intro.length() < MINIMUM_INTRO_LENGTH) {
			System.out.println("인트로 길이 에러메세지 // 최대 길이 : " + MINIMUM_INTRO_LENGTH);
			return;
		}
		this.intro = intro; 
	}
	public String getIntro() {
		return this.intro;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getFoundationDay() {
		return this.foundationDay;
	}
	
	public static TravelClub getSample() {
//1번 방법
//		String clubName = "Sample Club";
//		String intro = "Sample Club Intro~";
//		TravelClub sampleClub = new TravelClub(clubName, intro);
//		return sampleClub;
		
//2번 방법
		return  new TravelClub("Sample Club", "Sample Intro");
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TravelClub club ID : ").append(id);
		builder.append(", culbName : ").append(clubName);
		builder.append(", Intro : ").append(intro);
		builder.append(", FoundationDay : ").append(foundationDay);
		
		return builder.toString();	
	}
	
	}

	
	
	
