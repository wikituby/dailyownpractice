package tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HolidayFinder {

    public static void main(String[] args) {
        // get start date from user
        LocalDate startDate = LocalDate.parse(args[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // get end date from user
        LocalDate endDate = LocalDate.parse(args[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // find holidays between start and end dates
        ArrayList<LocalDate> holidays = findHolidays(startDate, endDate);

        // print holidays
        if (holidays.size() > 0) {
            System.out.println("Holidays between " + startDate + " and " + endDate + ":");
            for (LocalDate holiday : holidays) {
                System.out.println(holiday);
            }
        } else {
            System.out.println("No holidays between " + startDate + " and " + endDate);
        }
    }

    public static ArrayList<LocalDate> findHolidays(LocalDate startDate, LocalDate endDate) {
        ArrayList<LocalDate> holidays = new ArrayList<>();

        // iterate over dates between start and end dates
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            // check if date is a holiday and add it to the list if it is
            if (isHoliday(date)) {
                holidays.add(date);
            }

            // move to the next day
            date = date.plusDays(1);
        }

        return holidays;
    }

    public static boolean isHoliday(LocalDate date) {
        // define holidays here
        boolean isNewYear = date.getMonthValue() == 1 && date.getDayOfMonth() == 1;
        boolean isChristmas = date.getMonthValue() == 12 && date.getDayOfMonth() == 25;
        boolean isThanksgiving = date.getMonthValue() == 11 && date.getDayOfMonth() == 4 &&
                date.getDayOfWeek().getValue() == 4;

        // return true if date is a holiday, false otherwise
        return isNewYear || isChristmas || isThanksgiving;
    }
}
