package bit701.day0906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex11_ArrayRankInput {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] names = new String[4];
		int[] score = new int[4];
		int[] rank = new int[4];
		
		
		//입력
		for(int i =0 ; i < names.length ; i++) {
			System.out.print(i+1 + "번 이름 : ");
			names[i] = sc.nextLine();
			System.out.print(i+1 + "번 점수 : ");
			System.out.println();
			score[i] = Integer.parseInt(sc.nextLine());
			
			if(score[i] < 0 || score[i] > 100) {
				System.out.println("다시 입력하세요.");
				i--;
				continue;
			}
			System.out.println();
		}
		
		//등수 구하기
		for (int i = 0; i < score.length ; i++) {
			rank[i] = 1;
			for(int j = 0; j < score.length; j++) {
				if(score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		//출력
		System.out.println("번호 \t이름 \t점수(등수)");
		
		for(int i = 0 ; i < names.length ; i++) {
			System.out.println(i+1 + "\t" + names[i] + "\t" + score[i] + "(" + rank[i] + " 등)");
		}
		
		System.out.println("=".repeat(30));

		// 총 5명의 이름과 점수를 입력하면 이릅과 점수 그리고 등수를 출력하는 프로그램을 작성하시오.
		// 정렬없이 랭크 반환 처리해봄.
		
		List<Student> students = new ArrayList<>(Arrays.asList(new Student("일일이", 90, 0), new Student("이프로", 75, 0),
				new Student("삼삼당", 88, 0), new Student("사마귀", 88, 0), new Student("오늘은", 95, 0)));

		// list.stream() 형식은 list의 각 요소를 불러온다.

		List<Student> result = students.stream() // 반환타입 : Stream<Student> ; students의 각 요소가 객체인 Student이기 때문
				.map(i -> {
					int rankset = getRank(students, i.getScore());
					i.setRank(rankset);
					return i;
					// 반환타입 : Stream<Student>
					// collect(Collectors.toList());까지 작성해야 List<Student>로 반환됨.
				}).collect(Collectors.toList()); // 반환타입 : List<Student>

		for (Student stu : result) {
			System.out.println(stu);
		}

	}

	private static int getRank(List<Student> list, int score) {
		int rank = 1;

		for (Student student : list) {
			if (score > student.getScore()) {
				rank++;
			}
		}
		return rank;
	}
}

class Student {

	private String name;
	private int score;
	private int rank;

	public Student(String name, int score, int rank) {
		this.name = name;
		this.score = score;
		this.rank = rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	String getName() {
		return name;
	}

	int getScore() {
		return score;
	}

	int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return "[ name: " + name + ", score: " + score + ", rank : " + rank + " ]";
	}

}
