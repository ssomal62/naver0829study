package thisIsJava.chapter17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test_07 {

	public static void main(String[] args) {
		List<Member2> list = Arrays.asList(
				new Member2("홍길동", "개발자"),
				new Member2("김나리", "디자이너"),
				new Member2("신용권", "개발자")
				);
		//정답 입력부분 시작
		List<Member2> developers = list.stream().filter(i -> i.getJob().equals("개발자")).collect(Collectors.toList());
		developers.stream().forEach(m -> System.out.println(m.getName()));
		
	}
	
}

class Member2 {
	private String name;
	private String job;

	public Member2(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

}
