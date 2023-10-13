package bit701.day0911;

public class Member3 {

	private String name;
	private int basePay;
	private int allowance;
	private int familyNumberOf;

	public Member3(String name, int basePay, int allowance, int familyNumberOf) {
		super();
		this.name = name;
		this.basePay = basePay;
		this.allowance = allowance;
		this.familyNumberOf = familyNumberOf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBasePay() {
		return basePay;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public int getFamilyNumberOf() {
		return familyNumberOf;
	}

	public void setFamilyNumberOf(int familyNumberOf) {
		this.familyNumberOf = familyNumberOf;
	}

	public int getFamilyAllowance() {
		if (getFamilyNumberOf() >= 3) {
			return this.allowance = 10000;
		} else {
			return 50000;
		}
	}

	public int getTax() {
		return (int) (getBasePay() * 0.5);
	}

	public int payAll() {
		return (int) (getBasePay()+ getAllowance() + getFamilyAllowance() - getTax());
	}

	@Override
	public String toString() {

		return getName() + "\t" + getBasePay()+ "\t" + getAllowance() + "\t" + getFamilyNumberOf() + "\t" + getFamilyAllowance() + "\t\t" + getTax() + "\t|  " + payAll();
	}

}
