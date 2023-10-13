package bit701.day0914;

import java.util.HashMap;
import java.util.Map;

public class Ex10_Map {

    public static void main(String[] args) {
        //key와 value가 상으로 저장되는 형태 (이 때 key는 set 타입)
        Map<String, String> map = new HashMap<String, String>();

        map.put("name","김태희");
        map.put("age","30세");
        map.put("addr","강남구");
        map.put("name","송혜교"); // 같은 key값이 존재할 경우 마지막 값으로 덮어씌워짐.
        System.out.println("갯수 : " + map.size());
        System.out.println("이름 : " + map.get("name"));
        System.out.println("나이 : " + map.get("age"));
        System.out.println("주소 : " + map.get("addr"));
        System.out.println("혈액형 : " + map.get("blood"));//해당 key값이 없을 경우 값은 null 반환.

        System.out.println("addr 키값을 제거해보자");
        map.remove("adder");
        System.out.println("주소 : " + map.get("adder")); //제거 되었으므로 null값 반환.


    }
}
