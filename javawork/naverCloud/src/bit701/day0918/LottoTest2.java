package bit701.day0918;
import java.util.*;

public class LottoTest2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //돈 넣기
        int money;
        Scanner sc=new Scanner(System.in);
        System.out.print("로또를 구입할 금액을 입력하세요:");
        try {
            money=Integer.parseInt(sc.nextLine());
            if (money<1000) { //금액이 1000원 미만일
                System.out.println("[ERROR] 금액이 부족합니다.");
                return; //돌아가기
            }
            if (money%1000!=0)
            {
                System.out.println("[ERROR] 금액이 나누어떨어지지않습니다.");
                return; //돌아가기
            }
            System.out.print("\n당첨 번호 6개를 다음 양식으로 입력해주세요\n0,0,0,0,0,0:");

            String line=sc.nextLine();
            String []winArray=line.split(",");
            Set<Integer> winLotto=new TreeSet<Integer>();
            for(int i=0; i<winArray.length; i++)
            {
                int j=Integer.parseInt(winArray[i]);
                if(j<0||j>45) {
                    System.out.println("[ERROR] 로또번호는 1부터 45사이의 숫자여야합니다.");
                    return;
                }
                winLotto.add(j);
            }
            if(winLotto.size()!=6) {
                System.out.println("[ERROR] 중복된 숫자가 있습니다.");
                return;
            }
            System.out.print("보너스 번호를 입력해주세요:");
            int bonus=Integer.parseInt(sc.nextLine());

            int count = money/1000;
            int []winCount = new int[count];
            System.out.println("\n["+count+"개의 로또를 구매했습니다.]");
            List<Object> setLottoList = new ArrayList<Object>();

            int []result = new int[5];
            for(int c=0; c<result.length; c++) {
                result[c] = 0;
            }

            for (int i=0; i<count; i++)//로또갯수만큼포문
            {
                winCount[i] = 0;
                Set<Integer> setLotto=new TreeSet<Integer>();//샛컬렉션활용

                while(true)//로또안에난수입력
                {
                    int n=(int)(Math.random()*45)+1;//난수생성
                    setLotto.add(n);//난수입력

                    if(setLotto.size()==6) {
                        break;//종료
                    }

                }

                for(Integer q : setLotto) {
                    for(Integer j : winLotto) {
                        if(q == j) {
                            winCount[i] = winCount[i] + 1;
                        }
                    }
                }

//				for(Integer j : winLotto) {
//				System.out.println(i + " j : " + j + " n : " + n);
//				if(j == n) {
//					System.out.println("in if : " + i + " j : " + j + " n : " + n);
//					winCount[i] = winCount[i] + 1;
//				}
//			}

                switch(winCount[i]) {
                    case 3:
                        result[0] = result[0] + 1;
                        break;
                    case 4:
                        result[1] = result[1] + 1;
                        break;
                    case 5:
                        boolean bonusFlag = false;

                        for(Integer j : setLotto) {
                            if(j == bonus) {
                                bonusFlag = true;
                            }
                        }

                        if(bonusFlag) {
                            result[2] = result[2] + 1;
                        } else {
                            result[3] = result[3] + 1;
                        }
                        break;
                    case 6:
                        result[4] = result[4] + 1;
                        break;
                }


                setLottoList.add(setLotto);

            }

//			Iterator<Object> iter = setLottoList.iterator();
//			int chk = 0;
//			while(iter.hasNext()) {
            for(int i=0; i<setLottoList.size(); i++) {
                System.out.println(i + " ====== : " + setLottoList.get(i) + " 당첨갯수 : " + winCount[i]);
            }

            System.out.println("3개 일치 (5,000원) - " + result[0] + " 개");
            System.out.println("4개 일치 (50,000원) - " + result[1] + " 개");
            System.out.println("5개 일치 (1,500,000원) - " + result[2] + " 개");
            System.out.println("5개 일치, 보너스 볼 (30,000,000원) - " + result[3] + " 개");
            System.out.println("6개 일치 (2,000,000,000원) - " + result[4] + " 개");

            long totalRes = (result[0]*5000) + (result[1]*50000) + (result[2]*1500000) +(result[3]*30000000)+(result[4]*2000000000);
            System.out.println(totalRes);



        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닙니다.");
        }

    }
}
