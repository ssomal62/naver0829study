package view;

import java.util.Scanner;

import static java.lang.System.out;

public class ConsoleView {

    private static Scanner scanner = new Scanner(System.in);

    public static void outputMessage(String command){

        if(command.equals("start")){
            out.println("숫자 야구 게임을 시작합니다.");
        }
        if(command.equals("request")){
            out.print("숫자를 입력해주세요 : ");
        }
        if(command.equals("rechallenge")){
            out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        if(command.equals("end")){
            out.println("<프로그램 종료>");
        }
        if(command.equals("win")){
            out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if(command.equals("errNotNumber")){
            out.println("[오류] 입력값이 숫자가 아닙니다.");
        }
        if(command.equals("errDuplicateNumber")){
            out.println("[오류] 중복된 숫자가 있습니다.");
        }
        if(command.equals("errWrongLength")){
            out.println("[오류] 숫자 자릿수가 유효하지 않습니다.");
        }
    }

    public static void outputMessage(int strike, int ball){
        if(strike != 0 && ball != 0) {
            out.println(ball + "볼 " + strike + "스트라이크");
        }
        if(strike == 0 && ball != 0) {
            out.println(ball + "볼");
        }
        if(strike != 0 && ball == 0) {
            out.println(strike + "스트라이크");
        }
        if(strike == 0 && ball == 0) {
            out.println("낫싱");
        }
    }

    public String inputMessage(){
        return scanner.nextLine();
    }

}

