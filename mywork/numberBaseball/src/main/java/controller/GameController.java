package controller;

import domain.UserNumber;
import service.GameServiceImpl;
import utils.ConsoleUtil;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    final static int MAX_NUMBER = 3;
    boolean run = true;

    GameServiceImpl gameLogic;
    ConsoleUtil util;
    List<UserNumber> userInfo;

    public GameController() {
        gameLogic = new GameServiceImpl();
        util = new ConsoleUtil();
    }

    public void run(){

        String answer = "";

        while (run) {

            gameStart();

            if(run){
                ConsoleView.outputMessage("rechallenge");
                answer = ConsoleView.inputMessage();
            }

            if(!answer.equals("1")){
                ConsoleView.outputMessage("end");
                run = false;
                break;
            }
        }
    }

    public void gameStart() {

        ConsoleView.outputMessage("start");

        gameLogic.resetRandomNumber();

        while (true){
            userInfo = new ArrayList<>();

            String userNumber = util.requestNextInput();

            if(!util.checkComprehensivelyValue(userNumber)) {
                run = !run;
                break;
            }

            userInfo = gameLogic.sendUserValueToList(userNumber);

            int strike = gameLogic.checkStrikeCount(userInfo);
            int ball   = gameLogic.checkBallCount(userNumber, strike);

            ConsoleView.outputMessage(strike, ball);

            if(strike == MAX_NUMBER){
                ConsoleView.outputMessage("win");
                break;
            }

        }
    }
}
