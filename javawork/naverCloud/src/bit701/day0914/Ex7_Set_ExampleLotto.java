package bit701.day0914;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class Ex7_Set_ExampleLotto {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int money;
        System.out.println("로또를 구입할 금액을 입력하세요");

        try {
            money = Integer.parseInt(sc.nextLine());

            if (money < 1000) {
                System.out.println("금액이 부족합니다.");
                return;
            }
            for (int i = 1; i <= (money/1000); i++) {
                Set<Integer> setLotto = new TreeSet<Integer>();
                //6개의 난수를 구한다.

                while (true) {
                    int randomNum = (int) (Math.random() * 45) + 1;
                    setLotto.add(randomNum);
                    if (setLotto.size() == 6)
                        break;

                }
                System.out.printf("%2d회 : " , i);

                for(Integer k : setLotto){
                    System.out.printf("%3d",k);
                }
                System.out.println();


            }
        } catch (NullPointerException e) {
            System.out.println("금액은 숫자로만 입력해주세요." + e.getMessage());
        }
    }

}

