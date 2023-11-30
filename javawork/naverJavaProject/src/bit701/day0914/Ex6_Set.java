package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex6_Set {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
//TreeSet 정렬 순차적으로 나옴
        set.add("red");
        set.add("Blue");
        set.add("Green");
        set.add("red");
        set.add("Blue");
        set.add("green");
        set.add("red");
        set.add("blue");
        set.add("yellow");

//대문자 먼저 출력 그 다음 소문자 출력됨.

        System.out.println(set.size());

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("=".repeat(50));
        for (String s : set){
            System.out.println(s);
        }

        System.out.println("=".repeat(50));
    }



}
