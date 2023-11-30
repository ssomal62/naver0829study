package bit701.day0918;
//Java에서의 함수형 프로그램인 람다 표현식은 인터페이스를 사용하는 익명 내부 클래스의 또다른 표현식이다.
// 단, 인터페이스는 단 하나의 추상 메서드만을 가지고 있어야한다.
public class Ex5_Lambda2 {

    public static void main(String[] args) {
        Ex5_Lambda2 ex = new Ex5_Lambda2();
        ex.absMethid3();

    }

    public void absMethid3(){
//       DataAdd add1 = new DataAdd() {
//           @Override
//           public void add(int x, int y) {
//               System.out.println(x+y);
//
//           }
//       }
        DataAdd add1 = (x,y)->System.out.println(x+y);
        add1.add(100,200);
    }
}

@FunctionalInterface//메서드가 하나인지 아닌지 검증하는 역할을 함. 하나가 아니면 오류 나옴
interface Orange{
    public void write();
}

@FunctionalInterface
interface DataAdd{
  public void add (int x, int y);
}

