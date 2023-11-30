package utils;


import validation.UserValidation;
import view.ConsoleView;

public final class ConsoleUtil {

    UserValidation userValidation;

    public ConsoleUtil() {
        this.userValidation = new UserValidation();
    }

    public String requestNextInput(){
        ConsoleView.outputMessage("request");

        return  ConsoleView.inputMessage();
    }

    public boolean checkComprehensivelyValue (String userNumber){
        try {
            userValidation.checkValueType(userNumber);
            userValidation.checkNumberLength(userNumber);
            userValidation.checkDuplicateNumber(userNumber);
        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

}


// 다 지워버릴게요 이제 쓴게 없는걸요