import domain.UserNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.GameServiceImpl;
import utils.ConsoleUtil;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    private GameServiceImpl gameLogic;
    private ConsoleUtil util;

    final static int MAX_NUMBER = 3;

    @BeforeEach
    public void setUp() {
        gameLogic = new GameServiceImpl();
        gameLogic.resetRandomNumber();

        util = new ConsoleUtil();
    }

    @DisplayName("랜덤 숫자가 3자리이고, 중복이 없는지 확인")
    @Test
    void testCreateSystemRandomNumber() {

        //given

        //when
        List<Integer> randomNumbers = gameLogic.createSystemRandomNumber();

        //then
        assertEquals(MAX_NUMBER, randomNumbers.stream().distinct().count());
    }

    @DisplayName("사용자 입력 true/false 테스트")
    @Test
    void testCheckComprehensivelyValue() {
        //given
        String userInput1 = "135";       // 조건부합
        String userInput2 = "abc";       // 숫자가 아님
        String userInput3 = "1234567";   // 자릿수가 넘음
        String userInput4 = "333";       // 중복된 수

        //when
        boolean errResult1 = util.checkComprehensivelyValue(userInput1);
        boolean errResult2 = util.checkComprehensivelyValue(userInput2);
        boolean errResult3 = util.checkComprehensivelyValue(userInput3);
        boolean errResult4 = util.checkComprehensivelyValue(userInput4);

        //then
        assertTrue(errResult1);
        assertFalse(errResult2);
        assertFalse(errResult3);
        assertFalse(errResult4);
    }

    @DisplayName("UserInfo List에 값이 제대로 들어가는지 확인")
    @Test
    void testSendUserValueToList() {

        //given
        String userNumber = "745";

        //when
        List<UserNumber> userNumberList = gameLogic.sendUserValueToList(userNumber);

        //then
        assertEquals(userNumberList.get(0).getNumber(), 7);
        assertEquals(userNumberList.get(1).getNumber(), 4);
        assertEquals(userNumberList.get(2).getNumber(), 5);
    }
}