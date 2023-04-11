package tests;

import java.util.*;

public class CalendarProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");

        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <= daysInMonth; i++) {
            if (i == 1) {
                System.out.print(i + "\t");
            } else if ((i + firstDayOfWeek - 2) % 7 == 0) {
                System.out.println(i + "\t");
            } else {
                System.out.print(i + "\t");
            }
        }

        System.out.println();
        System.out.println("Example Holidays:");
        System.out.println("New Year's Day - January 1st");
        System.out.println("Martin Luther King Jr. Day - Third Monday in January");
        System.out.println("Valentine's Day - February 14th");
        System.out.println("St. Patrick's Day - March 17th");
        System.out.println("April Fool's Day - April 1st");
        System.out.println("Easter Sunday - Varies by year");
        System.out.println("Memorial Day - Last Monday in May");
        System.out.println("Independence Day - July 4th");
        System.out.println("Labor Day - First Monday in September");
        System.out.println("Halloween - October 31st");
        System.out.println("Thanksgiving Day - Fourth Thursday in November");
        System.out.println("Christmas Day - December 25th");
    }
}
