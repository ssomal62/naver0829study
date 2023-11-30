package bit701.day0914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex14_List {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList(
                //List는 데이터를 넣은 수차적으로 저장되고 중복데이터도 저장됨
                new String("장미꽃"),
                new String("안개꽃"),
                new String("장미꽃"),
                new String("국화꽃"),
                new String("데이지")
        ));


        //출력방법1
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("-".repeat(40));

        //출력방법2
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next() + " ");
        }
        System.out.println("-".repeat(40));

        //출력방법3
        Object[] data = list.toArray(); // toArray >> Object로 반환 !!!!! 새롭다 새롭다
        for(Object ob : data){
            System.out.println((String)ob + " ");
        }
        System.out.println("-".repeat(40));

        //투어레이 오브젝트 반환
        //투어레이 오브젝트 반환
        //투어레이 오브젝트 반환 투어레이 오브젝트 반환!!!!!

    }
}
