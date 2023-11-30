package 인터페이스일반상속;

public class Main {

	public static void main(String[] args) {

		개 ob1 = new 개();
		고양이 ob2 = new 고양이();
		고래 ob3 = new 고래();
		
		조류 ob4 = new 독수리();
		조류 ob5 = new 펭귄();
		
		상어 ob6 = new 상어();
		
		어류 어 = ob3;
		
		포유류[] 포 = new 포유류[] {ob1, ob2};
		조류[] 조= new 조류[] {ob4, ob5};
		
		동물[] ani= new 동물[] {
				ob1, ob2, ob3, ob4, ob5, ob6
		};
		
	//동물[] ani2 = new 동물[] {포[0], 포[2], 어, 조[0], 조[1]};
	//업캐스팅 : 상위개념을 이용함 
	//다운캐스팅 : 하위개념을 이용함	 하템 썬더?
		for(int i = 0; i < ani.length; i++) {
			ani[i].먹기();
			ani[i].울기();
			ani[i].이동하기();

			if(ani[i] instanceof 개) {
				개 tmp = (개)ani[i];
				tmp.개만의특징();
			}
			
		}
		
		
	}

}
