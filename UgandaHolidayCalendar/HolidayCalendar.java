package UgandaHolidayCalendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class HolidayCalendar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // prompt the user to enter start and end dates
        System.out.println("Enter start date (yyyy-MM-dd):");
        //String startDateString = System.console().readLine();
        String startDateString = String.valueOf(scanner.nextInt());

        //LocalDate startDate = LocalDate.parse(getInput("Enter start date (yyyy-mm-dd): "));
        //LocalDate endDate = LocalDate.parse(getInput("Enter end date (yyyy-mm-dd): "));

        System.out.println("Enter end date (yyyy-MM-dd):");
        String endDateString = String.valueOf(scanner.nextInt());

        //String endDateString = System.console().readLine();

        // parse start and end dates
        LocalDate startDate = LocalDate.parse(startDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(endDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // find holidays between start and end dates
        ArrayList<LocalDate> holidays = findHolidays(startDate, endDate);

        // print holidays
        if (holidays.size() > 0) {
            System.out.println("Holidays between " + startDateString + " and " + endDateString + ":");
            for (LocalDate holiday : holidays) {
                System.out.println(holiday);
            }
        } else {
            System.out.println("No holidays between " + startDateString + " and " + endDateString);
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
