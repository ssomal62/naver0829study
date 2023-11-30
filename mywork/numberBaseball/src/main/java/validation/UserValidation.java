package validation;

import view.ConsoleView;

public class UserValidation {

    public boolean checkValueType(String userNumber) {

        if (Integer.parseInt(userNumber) <= 0) {
            ConsoleView.outputMessage("errNotNumber");
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean checkNumberLength(String userNumber) {

        if (3 != userNumber.length()) {
            ConsoleView.outputMessage("errWrongLength");
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean checkDuplicateNumber(String userNumber) {
        int duplicateCount = (int) (userNumber.chars().distinct().count());

        if (3 != duplicateCount) {
            ConsoleView.outputMessage("errDuplicateNumber");
            throw new IllegalArgumentException();
        }
        return true;
    }

}
