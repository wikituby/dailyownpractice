package Practice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Calendar;

public class HolidayPrint {
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

        List<LocalDate> holidays = new ArrayList<>();
        Map<LocalDate, String> holidayNames = new HashMap<>();
        holidayNames.put(LocalDate.of(year, Month.JANUARY, 1), "New Year's Day");
        holidayNames.put(LocalDate.of(year, Month.DECEMBER, 25), "Christmas Day");

        for (int i = 1; i <= daysInMonth; i++) {
            LocalDate date = LocalDate.of(year, month, i);
            boolean isHoliday = holidayNames.containsKey(date);
            boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;

            if (isHoliday) {
                holidays.add(date);
                System.out.printf("\u001B[31m%2d*\u001B[0m ", i);
            } else if (isWeekend) {
                System.out.printf("\u001B[33m%2d\u001B[0m ", i);
            } else {
                System.out.printf("%2d ", i);
            }

            if ((i + dayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("Public holidays:");
        for (LocalDate date : holidays) {
            System.out.printf("%s: %s\n", date.format(DateTimeFormatter.ofPattern("MMMM d")), holidayNames.get(date));
        }
    }
}

