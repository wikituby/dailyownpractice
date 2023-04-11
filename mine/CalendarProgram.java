package mine;

import java.util.*;

public class CalendarProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = 0;
        while (true) {
            System.out.print("Enter year (1800-2023): ");
            try {
                //year = Integer.parseInt(input.nextLine());
                year = scanner.nextInt();

                if (year < 1800 || year > 2023) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid year. Please enter a valid year between 1800 and 2023.");
            }
        }

        int month = 0;
        while (true) {
            System.out.print("Enter month (1-12): ");
            try {
                //month = Integer.parseInt(input.nextLine());
                month = scanner.nextInt();

                if (month < 1 || month > 12) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid month. Please enter a valid month between 1 and 12.");
            }
        }


        // Prompt user to input year and month
        /*System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();*/

        // Create a calendar object and set the year and month
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Note: month is 0-based in Calendar

        // Print the month header
        System.out.println("\n      " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        // Get the first day of the month and the number of days in the month
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1; // Note: Sunday is 1 in Calendar, so we subtract 1
        int numDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Print the blanks before the first day of the month
        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");
        }

        // Print the days of the month
        for (int i = 1; i <= numDays; i++) {
            if (i < 10) {
                System.out.print(" ");
            }
            System.out.print(i);

            // Check if the current day is a holiday and print the holiday name
            calendar.set(Calendar.DAY_OF_MONTH, i);
            if (calendar.get(Calendar.MONTH) == Calendar.JANUARY && i == 1) {
                System.out.print("*"); // new year
            } else if (calendar.get(Calendar.MONTH) == Calendar.FEBRUARY && i == 14) {
                System.out.print("*"); // Valentine's Day
            } else if (calendar.get(Calendar.MONTH) == Calendar.MAY && i == 10) {
                System.out.print("*"); // Mother's Day
            } else if (calendar.get(Calendar.MONTH) == Calendar.JUNE && i == 21) {
                System.out.print("*"); // Father's Day
            } else if (calendar.get(Calendar.MONTH) == Calendar.JULY && i == 4) {
                System.out.print("*"); // Independence Day
            } else if (calendar.get(Calendar.MONTH) == Calendar.OCTOBER && i == 31) {
                System.out.print("*"); // Halloween
            }

            System.out.print(" ");

            // If the current day is Saturday, start a new line
            if ((i + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
    }
}

