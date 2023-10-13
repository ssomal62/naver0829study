package bit701.day0914;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex15_ListStudent {
    List<Student> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Student student;
    int index = 0;
    public Ex15_ListStudent(){
        list.add(new Student("홍길동",99,"A"));
        list.add(new Student("강호동",10,"O"));
        list.add(new Student("캔디바",78,"AB"));
        list.add(new Student("우재석",69,"B"));
        list.add(new Student("안쏘지",89,"A"));
        System.out.println("총 " + list.size() + "명");
    };

    public int getMenu(){

        int num = 0;
        System.out.println("\n 1 학생추가 | 2 학생삭제 | 3 학생검색 | 4 전체출력 | 5 종료");
        System.out.printf("선택하세요 >> ");

        try{
            num = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            num = 4;  //번호에 문자가 들어 간 경우 4번 전체 출력 호출하기
        }
        return num;
    }

    public void addStudent(){
        System.out.println("💙학생을 추가합니다.");
        System.out.printf("학생명 >> ");
        String name = sc.nextLine();
        System.out.printf("점수 >> ");

        int score = 0;

        try{
            score = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            score = 30;//잘못입력했을 때 기본점수
        }

        System.out.printf("혈액형 >> ");
        String blood = sc.nextLine().toUpperCase();

        student = new Student();
        student.setName(name);
        student.setScore(score);
        student.setBlood(blood);

        list.add(student);//이거 안하면 등록이 안됨.
        System.out.println(list.size() + "번째 학생 정보 추가 완료.");
        System.out.println("-".repeat(40));
    }

    public void deleteStudent(){
        System.out.println("💙선택 학생을 삭제합니다.");
        listStudent();

        System.out.printf("💙삭제할 학생 번호를 선택하세요. >> ");
        int deleteNum = Integer.parseInt(sc.nextLine());
        String delName = list.get(deleteNum-1).getName();
        list.remove(deleteNum-1);
        System.out.println("💙" + delName + "학생 삭제 완료!");
        System.out.println("-".repeat(40));

    }

    public void searchStudent(){
        System.out.println("💙학생을 검색합니다.");
        System.out.printf("💙검색할 학생 이름 >> ");
        String searchName = sc.nextLine();
        index = 0;
        boolean check = true;
        for(Student stu : list){
            if(searchName.equals(stu.getName())){
                System.out.println("💙학생을 찾았어요!");
                System.out.println("\tno.\t 이름\t\t점수\t\t혈액형");
                System.out.println("\t" + (index++ +1) + "\t" +stu.getName()+ "\t\t" + stu.getScore()+ "\t\t" + stu.getBlood());
                check  = !check;
                break;
            }
        }
        if(check == true){
            System.out.println("💙앗! 해당 학생이 없네요.");

        }

    }

    public void listStudent(){
        System.out.println("💙학생 목록을 불러옵니다.");
        System.out.println("\tno.\t 이름\t\t점수\t\t혈액형");
        System.out.println("-".repeat(40));
        index = 0;
        for(Student stu : list){
            System.out.println("\t" + (index++ +1) + "\t" +stu.getName()+ "\t\t" + stu.getScore()+ "\t\t" + stu.getBlood());
        }
        System.out.println("-".repeat(40));
    }

    public static void main(String[] args) {
        Ex15_ListStudent ex = new Ex15_ListStudent();

        Exit:
        while (true){

            switch(ex.getMenu()){

                case 1:
                    ex.addStudent();
                    break;
                case 2:
                    ex.deleteStudent();
                    break;
                case 3:
                    ex.searchStudent();
                    break;
                case 4:
                    ex.listStudent();
                    break;
                default :
                    System.out.println("** 프로그램 종료 **");
                    break Exit;

            }

        }

    }

}
