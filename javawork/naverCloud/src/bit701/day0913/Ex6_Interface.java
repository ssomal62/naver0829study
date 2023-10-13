package bit701.day0913;

interface InterJobA{
	public void insertDB();
	public void deleteDB();
}

interface InterJobB extends InterJobA{
	public void seletJob();
	public void updateJob();
}

class JobOne implements InterJobA{

	@Override
	public void insertDB() {
	System.out.println("학생 추가 DB 작업");
		
	}

	@Override
	public void deleteDB() {
		System.out.println("학생 제거 DB 작업");
		
	}


	
}

class JobTwo implements InterJobB{

	@Override
	public void insertDB() {
		System.out.println("고난도 학생 추가 DB 작업");
	}

	@Override
	public void deleteDB() {
		System.out.println("고난도 학생 제거 DB 작업");
	}

	@Override
	public void seletJob() {
		System.out.println("DB 말단 업무 배정 완료");
	}

	@Override
	public void updateJob() {
		System.out.println("DB 팀장 업무 배정 완료");
	}
	
}

public class Ex6_Interface {
	
	public static void main(String[] args) {
		
		//InterJobA a = new JobOne();		
		//a.insertDB();
		//a.deleteDB();
		
		
		InterJobB b = new JobTwo();

		b.deleteDB();
		b.seletJob();
		b.updateJob();
		
		
		
		
		
		
	}

}
