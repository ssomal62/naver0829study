package bit701.day0914;

import java.util.Stack;

public class Ex12_Stack {

    public static void main(String[] args) {


        String[] groupA = {"우즈베키스탐","프랑스","미국","영국","태국","스위슾","대한민국"};
        //Last-In-First-Out : LIFO구조

        Stack<String> stack = new Stack<String>();

        //stack에 데이터 추가하기
        for(String g : groupA){
            stack.push(g);
        }

        System.out.println("pop으로 데이터 꺼내 출력하기");

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
