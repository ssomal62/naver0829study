package bit701.day0914;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalTest {

    public static void main(String[] args) {


       // System.out.println(Calendar.OCTOBER + "월");

//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String formatDate = currentDate.format(formatter);
//        System.out.println("현재 날짜: " + formatDate);



        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(currentDate);
        System.out.println("현재 날짜: " + formattedDate);

    }
}
