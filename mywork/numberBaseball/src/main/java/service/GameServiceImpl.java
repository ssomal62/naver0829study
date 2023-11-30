package service;

import domain.UserNumber;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameServiceImpl implements GameService {

    public List<Integer> randomList;
    public void resetRandomNumber() {
        randomList = createSystemRandomNumber();
    }

    @Override
    public List<Integer> createSystemRandomNumber() {
        return IntStream.iterate(0, randomNum -> randomNum)
                .map(randomNum -> (int)(Math.random() * 9) + 1)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<UserNumber> sendUserValueToList(String userNumber) {
        return userNumber.chars()
                .mapToObj(ch -> new UserNumber(Character.getNumericValue(ch)))
                .collect(Collectors.toList());
    }

    @Override
    public int checkStrikeCount(List<UserNumber> userInfo){
        return (int)(IntStream.rangeClosed(0,userInfo.size() - 1)
                   .filter(idx -> randomList.get(idx) == userInfo.get(idx).getNumber())
                   .count());
    }

    @Override
    public int checkBallCount(String userNumber, int strike){
       return (int)(randomList.stream()
               .filter(sNum -> userNumber.contains(String.valueOf(sNum)))
               .count()) - strike;
    }
}
