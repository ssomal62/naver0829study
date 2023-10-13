package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex5_List {

	static final String STUDENT_FILE = "C:/Temp/list.txt";
	Student_List[] stu = new Student_List[20];

	int count;

	public Ex5_List() throws IOException {

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(STUDENT_FILE);
			br = new BufferedReader(fr);
			count = 0;
			while (true) {

				String line = br.readLine();
				if (line == null) {
					break;
				}

				String[] data = line.split(",");

				String name = data[0];
				int kor = Integer.parseInt(data[1]);
				int eng = Integer.parseInt(data[2]);

				stu[count] = new Student_List(name, kor, eng);
				count++;

			}
			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

	public void dataList() {
		System.out.println("총" + count + "명");
		System.out.println("이름\t국어\t영어\t총점\t평균");
		System.out.println("-".repeat(40));
		for (int i = 0; i < count; i++) {
			int total = stu[i].getKor() + stu[i].getEng();
			double avg = total / 2.0;
			System.out.println(
					stu[i].getName() + "\t" + stu[i].getKor() + "\t" + stu[i].getEng() + "\t" + total + "\t" + avg);
		}

	}

	public static void main(String[] args) throws IOException {
		Ex5_List ex = new Ex5_List();
		ex.dataList();

	}

}

class Student_List {

	private String name;
	private int kor;
	private int eng;

	public Student_List(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	@Override
	public String toString() {
		return "List {name : " + name + ", kor : " + kor + ", eng : " + eng + "}";
	}

}
