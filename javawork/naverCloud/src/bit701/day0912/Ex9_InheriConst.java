package bit701.day0912;

class SuperD{
	
	
	private String carName;
	private String carColor;
	
	SuperD(){
		System.out.println("부모의 디폴트 생성자");
		carName = "서니티";
		carColor = "노랑색";
	}
	
	SuperD(String carName, String carColor){
		System.out.println("부모의 디폴트 생성자");
		this.carName = carName;
		this.carColor = carColor;
	}
	

	public void CarInfo() {
		System.out.println("SuperD {자동차명: " + carName + ", 자동차색 : " + carColor + "}");
	}
	
	
}

class SubD extends SuperD{
	
	private int carPrice;
	
	SubD(){
		System.out.println("sub 디폴트 생성자");
		this.carPrice = 3600;
	}

	public SubD( String carName,  String carColor, int carPrice) {
		super(carName, carColor);
		this.carPrice =4000;
	}

	
	@Override
	public void CarInfo()  {
		System.out.println("자동차 가격 : " + this.carPrice); 
		System.out.println("=".repeat(40));
	}
	
	
	

}

public class Ex9_InheriConst {

	public static void main(String[] args) {

		
		SubD sub1 = new SubD();
		sub1.CarInfo();
		
		SubD sub2 = new SubD("벤츠","검정",5500);
		sub2.CarInfo();

		
		}
	
}
