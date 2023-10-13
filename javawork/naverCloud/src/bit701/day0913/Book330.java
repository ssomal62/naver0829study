package bit701.day0913;

//자식클래스를 EMmpoyee와, Manager만 허용
sealed class Person permits Employee, Manager {
	public String name;

	public void work() {
		System.out.println("하는 일이 결정되지 않았습니다.");

	}

}

final class Employee extends Person{//이 클래스는 final 로 선언해서 더 이상 자식 클래스를 만들 수 없다. (상속 시킬 수 없다.)
	@Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
		System.out.println("하는 일이 결정되지 않았습니다.");
	}
	
}

non-sealed class Manager extends Person{//상속이 가능한 클래스 
	@Override
	public void work() {
		// TODO Auto-generated method stub
		super.work();
		System.out.println("매니저일입니다.");
	}
	
}
public class Book330 {

	public static void main(String[] args) {
		
		Person p = new Employee();
		p.work();
		
		p = new Manager();
		p.work();

	}
}
