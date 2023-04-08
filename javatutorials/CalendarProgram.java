package javatutorials;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class CalendarProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year;
        do {
            System.out.print("Enter the year between 1800 and 2023: ");
            year = scanner.nextInt();
        } while (year < 1800 || year > 2023);

        int month;
        do {
            System.out.print("Enter the month (1-12): ");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);

        boolean quit = false;
        while (!quit) {
            System.out.println("\nMenu:");
            System.out.println("1. View calendar for the month");
            System.out.println("2. Go to date");
            System.out.println("3. View year");
            System.out.println("4. View public holidays");
            System.out.println("5. Quit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printMonthCalendar(year, month);
                    break;
                case 2:
                    goToDate();
                    break;
                case 3:
                    printYearCalendar(year);
                    break;
                case 4:
                    viewPublicHolidays(year);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void printMonthCalendar(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        System.out.println("   " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfWeek = 1;
        for (int dayOfMonth = 1; dayOfMonth <= maxDayOfMonth; dayOfMonth++) {
            if (dayOfWeek < firstDayOfWeek) {
                System.out.print("   ");
            }
            System.out.printf("%2d ", dayOfMonth);
            if (dayOfWeek == 7) {
                System.out.println();
                dayOfWeek = 1;
            } else {
                dayOfWeek++;
            }
        }
        System.out.println();
    }

    private static void goToDate() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the day: ");
        int day = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        System.out.println("You have gone to the date: " + calendar.getTime());
    }

    private static void printYearCalendar(int year) {
        for (int month = 1; month <= 12; month++) {
            printMonthCalendar(year, month);
        }
    }
    /*private static void printYearCalendar(int year) {
        System.out.println("Year " + year + ":");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);

        // Add public holidays to a list
        List<Calendar> holidays = new ArrayList<>();
        holidays.add(calendar); // add example holiday date here

        // Loop through each month of the year
        for (int month = Calendar.JANUARY; month <= Calendar.DECEMBER; month++) {
            calendar.set(Calendar.MONTH, month);
            System.out.println("   " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + ":");

            // Loop through each week of the month
            int weeksInMonth = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
            for (int week = 1; week <= weeksInMonth; week++) {
                // Loop through each day of the week
                for (int dayOfWeek = Calendar.SUNDAY; dayOfWeek <= Calendar.SATURDAY; dayOfWeek++) {
                    calendar.set(Calendar.WEEK_OF_MONTH, week);
                    calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
                    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                    // Check if the current date is a holiday
                    if (holidays.contains(calendar)) {
                        // If it is, highlight the text in red
                        System.out.print("\u001B[31m" + dayOfMonth + "\u001B[0m ");
                    } else {
                        // If not, print the day normally
                        System.out.print(dayOfMonth + " ");
                    }
                }
                System.out.println();
            }
        }
    }*/


    private static void viewPublicHolidays(int year) {
        System.out.println("Public holidays for " + year + ":");
        // Add code here to print the public holidays for the year

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);

        // Add public holidays to a list
        List<Calendar> holidays = new ArrayList<>();
        holidays.add(calendar); // add example holiday date here

        // Loop through each month of the year and highlight any holidays
        for (int month = Calendar.JANUARY; month <= Calendar.DECEMBER; month++) {
            calendar.set(Calendar.MONTH, month);
            System.out.println("   " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + ":");

            // Loop through each day of the month
            for (int day = 1; day <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); day++) {
                calendar.set(Calendar.DAY_OF_MONTH, day);

                // Check if the current date is a holiday
                if (holidays.contains(calendar)) {
                    // If it is, highlight the text in red
                    System.out.print("\u001B[31m" + day + "\u001B[0m ");
                } else {
                    // If not, print the day normally
                    System.out.print(day + " ");
                }
            }
            System.out.println();
        }
    }

}

