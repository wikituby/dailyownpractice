package UgandaHolidayCalendar;

import java.util.*;

public class AllPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();
        scanner.nextLine(); // consume the newline character left by nextInt()

        // create a Calendar object for the given year and month
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Calendar months are 0-based

        // prompt user to enter custom holidays
        List<Integer> holidays = new ArrayList<>();
        System.out.print("Enter custom holidays (separated by spaces): ");
        String[] holidayStrings = scanner.nextLine().split(" ");
        for (String holidayString : holidayStrings) {
            holidayString = holidayString.trim(); // remove leading/trailing whitespace
            if (!holidayString.isEmpty()) {
                int holiday = Integer.parseInt(holidayString);
                holidays.add(holiday);
            }
        }

        // print the calendar header
        System.out.println("  S  M  T  W  T  F  S");

        // get the number of days in the month
        int numDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // get the day of the week for the first day of the month
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);

        // print leading spaces if necessary
        for (int i = 1; i < startDay; i++) {
            System.out.print("   ");
        }

        // print the days of the month, highlighting holidays
        for (int day = 1; day <= numDays; day++) {
            boolean isHoliday = holidays.contains(day);
            if (isHoliday) {
                System.out.print("\033[31m"); // ANSI escape code for red text
            }
            System.out.printf("%2d ", day);
            if (isHoliday) {
                System.out.print("\033[0m"); // ANSI escape code to reset text color
            }

            if (startDay == Calendar.SATURDAY) {
                System.out.print("\n");
            }
            startDay = (startDay % 7) + 1; // increment the day of the week
        }

        // print trailing spaces if necessary
        if (startDay != Calendar.SUNDAY) {
            System.out.println();
        }

        // print custom holidays
        if (!holidays.isEmpty()) {
            System.out.println("\nCustom Holidays:");
            for (int holiday : holidays) {
                System.out.printf("%2d\n", holiday);
            }
        }
    }
}
