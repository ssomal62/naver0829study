package bit701.day0918;

import java.time.LocalDate;

public class test2 {
    public static void main(String[] args) {

                LocalDate immutableDate = LocalDate.now();
                System.out.println("Original Date: " + immutableDate);

                // 날짜를 변경하려고 시도
                immutableDate.plusYears(1);
                immutableDate.plusMonths(1);
                immutableDate.plusDays(1);

                System.out.println("Unmodified Date: " + immutableDate);
            }
        }

