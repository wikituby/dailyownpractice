package NewQeury;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class CalendarProgramprIntAll {

    public static void main(String[] args) {
        // prompt the user for a month and year
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // create a calendar object for the specified month and year
        LocalDate date = LocalDate.of(year, month, 1);
        int numDays = date.lengthOfMonth();
        DayOfWeek firstDayOfWeek = date.getDayOfWeek();

        // create a date format for printing out the calendar
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");

        // create a set of public holidays for the specified month and year
        Set<Integer> publicHolidays = getPublicHolidays(month, year);

        // print out the calendar
        System.out.println(date.getMonth().toString() + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int dayOfWeek = 0;
        for (int day = 1; day <= numDays; day++) {
            if (day == 1) {
                // pad the first row with empty spaces up to the first day of the week
                for (int i = 0; i < firstDayOfWeek.getValue(); i++) {
                    System.out.print("   ");
                    dayOfWeek++;
                }
            }
            if (publicHolidays.contains(day)) {
                System.out.print("\033[31m"); // set red text color
            }
            System.out.print(formatter.format(date.withDayOfMonth(day)));
            System.out.print(" ");
            if (publicHolidays.contains(day)) {
                System.out.print("\033[0m"); // reset text color
            }
            dayOfWeek++;
            if (dayOfWeek > 6) {
                // start a new row on the next line
                System.out.println();
                dayOfWeek = 0;
            }
        }
        if (dayOfWeek != 0) {
            // pad the last row with empty spaces up to the end of the week
            for (int i = dayOfWeek; i < 7; i++) {
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    // get a set of public holidays for the specified month and year
    private static Set<Integer> getPublicHolidays(int month, int year) {
        Set<Integer> holidays = new HashSet<>();
        switch (month) {
            case 1: // January
                holidays.add(1); // New Year's Day
                break;
            case 2: // February
                // no public holidays in February
                break;
            case 3: // March
                holidays.add(getNthDayOfWeekInMonth(2, DayOfWeek.MONDAY, year, month)); // Labor Day
                holidays.add(getNthDayOfWeekInMonth(3, DayOfWeek.SUNDAY, year, month)); // Palm Sunday
                holidays.add(getNthDayOfWeekInMonth(4, DayOfWeek.THURSDAY, year, month)); // Maundy Thursday
                holidays.add(getNthDayOfWeekInMonth(4, DayOfWeek.FRIDAY, year, month)); // Good Friday
                holidays.add(getNthDayOfWeekInMonth(4, DayOfWeek.SUNDAY, year, month)); // Easter Sunday
                break;
            case 4: // April
                holidays.add(18); // Labor Day
                break;
            case 5://May
                holidays.add(9); // Independence Day
                break;
            case 6: // June
                holidays.add(getNthDayOfWeekInMonth(3, DayOfWeek.SUNDAY, year, month)); // Father's Day
                break;
            case 7: // July
                holidays.add(25); // Christmas in July
                break;
            case 8: // August
                holidays.add(15); // Assumption Day
                break;
            case 9: // September
                holidays.add(getNthDayOfWeekInMonth(3, DayOfWeek.MONDAY, year, month)); // Labor Day
                holidays.add(getNthDayOfWeekInMonth(2, DayOfWeek.SATURDAY, year, month)); // International Coastal Cleanup Day
                break;
            case 10: // October
                holidays.add(getNthDayOfWeekInMonth(2, DayOfWeek.MONDAY, year, month)); // Columbus Day
                holidays.add(getNthDayOfWeekInMonth(4, DayOfWeek.TUESDAY, year, month)); // National Night Out
                holidays.add(31); // Halloween
                break;
            case 11: // November
                holidays.add(1); // All Saints' Day
                holidays.add(getNthDayOfWeekInMonth(4, DayOfWeek.THURSDAY, year, month)); // Thanksgiving Day
                holidays.add(getNthDayOfWeekInMonth(4, DayOfWeek.FRIDAY, year, month)); // Black Friday
                break;
            case 12: // December
                holidays.add(8); // Immaculate Conception Day
                holidays.add(24); // Christmas Eve
                holidays.add(25); // Christmas Day
                holidays.add(31); // New Year's Eve
                break;
        }
        return holidays;
    }

    // get the date of the nth occurrence of a day of the week in a month and year
    private static int getNthDayOfWeekInMonth(int n, DayOfWeek dayOfWeek, int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int dayOffset = dayOfWeek.getValue() - date.getDayOfWeek().getValue();
        if (dayOffset < 0) {
            dayOffset += 7;
        }
        int dayOfMonth = 1 + dayOffset + (n - 1) * 7;
        if (dayOfMonth > date.lengthOfMonth()) {
            throw new IllegalArgumentException("Invalid date");
        }
        return dayOfMonth;
    }
}

