package thisIsJava.chapter16;

import java.util.List;

public class Test04 {
	
	private static Student[] students = {
			new Student("홍길동",77,96),
			new Student("신용권",55,93)
	};
	
	//avg메소드 작성 //chatGpt의 도움을 받아 풀었습니다. ㅠㅠ
	
	
    public static double avg(Function<Student> fun) {
    	int sum = 0; 	
    	for(Student student  : students) {
    		sum+= fun.apply(student);
    		//자 함수영역에 student가 오는 거는 끌어다 쓸 때는 
    		//student 내 여러 메소드들이 다 동일한 방식으로 호출되게끔 하려는거야.
    		//제네릭으로 정의하고 그 안에 타입 맞춰서 꺼내쓰라는거지.
    	}
    	return (double)sum/students.length;
    }
    
    public static String str(FunctionStr<Student> fun) {
    	String nameArray = "";
    	
    	for(Student student : students) {
    		nameArray += fun.apply(student)+ " ";
    		//fun.apply(student) 이 아닌 student로 하면 toString 형태로 반환되더라..
    	}
		return nameArray;	
    }
	
	public static void main(String[] args) {
		
		
		double engAvg = avg(Student::getEnglishScore);//숫자 값을 가져올 수 있음 되는건가?
		double mathAvg = avg (s-> s.getMathScore());
		//String a = avg(Student::getName); 자 타입이 안맞으니까 이런일이 생기는거야!

		String result = str(Student::getName);

		
		System.out.println(engAvg);
		System.out.println(mathAvg);
		
		System.out.println(result);
		
	}



}



class Student{
	private String name;
	private int englishScore;
	private int mathScore;
	
	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
	
	public String getName(){return name;}
	public int getEnglishScore() {return englishScore;}
	public int getMathScore() {return mathScore;}

	@Override
	public String toString() {
		return "Student [name=" + name + ", englishScore=" + englishScore + ", mathScore=" + mathScore + "]";
	}

	
}

//아직 이해는 못하지겠지만서도...
//아마도 해당 타입으로 반환을 한다는 의미인걸까? double이면 더블?

@FunctionalInterface
interface Function<T> {
	public double apply(T t);

}
@FunctionalInterface
interface FunctionStr<T> {
	public String apply(T t);
}

