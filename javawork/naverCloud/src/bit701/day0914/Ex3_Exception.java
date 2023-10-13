package bit701.day0914;

import java.util.Scanner;

public class Ex3_Exception {

    public static void dataInput() throws NumberFormatException, NullPointerException{ //Exception이 발생하면 호출하는 곳으로 예외를 던진다.
        Scanner sc = new Scanner(System.in);

        System.out.println("두개의 숫자를 입력하시오");
        int su1 = Integer.parseInt(sc.nextLine());
        int su2 = Integer.parseInt(sc.nextLine());
        System.out.printf("% d + %d= %d%n",su1, su2, su1+su2);
    }

    public static void main(String[] args) {


        try{
            dataInput();
        }catch (NumberFormatException e) {
            System.out.println("숫자로만 입력을 하세요");
        }catch (    NullPointerException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("정상 종료");
        }





    }

}
