package Practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int daysInMonth = currentDate.lengthOfMonth();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(currentDate.getMonth() + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%2d ", i);
            if ((i + dayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }
}

