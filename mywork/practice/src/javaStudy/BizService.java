package javaStudy;

public class BizService {

	public void bizMethod(int i) throws BizException{
		System.out.println("비즈메소드 시작");
		
		if(i < 0) {
			throw new BizException("매개변수 :i는 0이상이어야합니다.");
		}
		
		System.out.println("비즈메소드 종료");
	}

}
