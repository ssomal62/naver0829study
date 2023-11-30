package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex5_Set {
    //set 인터페이스의 특징 : 1. 순차적이 아니다. 2 중복허용 안함


    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        System.out.println(set.size());

        set.add(5);
        set.add(57);
        set.add(510);
        set.add(10);
        set.add(5);


        System.out.println(set.size());
        System.out.println("=".repeat(30));

        for(Integer i : set){
            System.out.println(i);
        }
        System.out.println("=".repeat(30));

        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println();
        System.out.println("=".repeat(30));
    }





}
