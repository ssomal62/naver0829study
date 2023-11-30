package service;

import domain.UserNumber;

import java.util.List;

public interface GameService {

    List<Integer>  createSystemRandomNumber();

    List<UserNumber> sendUserValueToList(String userNumber);

    int checkStrikeCount(List<UserNumber> userInfo);

    int checkBallCount(String userNumber, int strike);

}
