package bit701.day0914;

import java.util.Vector;

public class Ex13_List {

    public static void main(String[] args) {

        Vector<String> list1 = new Vector<>();
        System.out.println("list1의 할당 갯수 : " + list1.capacity());//기본 10개 할당 후 10개씩 증가

        Vector<String> list2 = new Vector<>(5);
        System.out.println("list2의 할당 갯수 : " + list2.capacity());//기본 5개 할당 후 5개씩 증가

        Vector<String> list3 = new Vector<>(3,2);//기본 3개 할당 후 2개씩 증가
        System.out.println("list3의 할당 갯수 : " + list3.capacity());

        list3.add("red");
        list3.add("blue");
        list3.add("green");
        list3.add("yellow");

        System.out.println("list3의 할당 갯수 : " + list3.capacity());
        System.out.println("list3의 데이터 갯수 : " + list3.size());


    }
}
