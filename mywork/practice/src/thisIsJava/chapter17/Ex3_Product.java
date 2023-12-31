package thisIsJava.chapter17;

public class Ex3_Product {
	
	private int pno;
	private String name;
	private String company;
	private int price;
	
	public Ex3_Product(int pno, String name, String company, int price) {
		super();
		this.pno = pno;
		this.name = name;
		this.company = company;
		this.price = price;
	}

	public int getPno() {return pno;}
	public String getName() {return name;}
	public String getCompany() {return company;}
	public int getPrice() {return price;}

	@Override
	public String toString() {
		
		return new StringBuilder()
				.append("{")
				.append("pno : " + pno + ", ")
				.append("name : " + name + ", ")
				.append("company : " + company + ", ")
				.append("price : " + price + ", ")
				.toString();
			
	}
	
	
	

	

	


}
