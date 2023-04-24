package NewQeury;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonthView {

    public void monthView() {
        Scanner scanner = new Scanner(System.in);

        // Define a map of holidays for the year
        Map<LocalDate, String> holidays = new HashMap<>();
        holidays.put(LocalDate.of(2023, 1, 1), "New Year's Day");
        holidays.put(LocalDate.of(2023, 7, 4), "Independence Day");
        holidays.put(LocalDate.of(2023, 12, 25), "Christmas Day");
        holidays.put(LocalDate.of(2023, 4, 7), "Good Friday");
        holidays.put(LocalDate.of(2023, 12, 1), "new end of year day xmass gig");



        int year = 0;
        while (true) {
            System.out.print("Enter year after (1800): ");
            try {
                //year = Integer.parseInt(input.nextLine());
                year = scanner.nextInt();

                if (year < 1800) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid year. Please enter a valid year after 1800.");
            }
        }

        int month2 = 0;
        while (true) {
            System.out.print("Enter month (1-12): ");
            try {
                //month = Integer.parseInt(input.nextLine());
                month2 = scanner.nextInt();

                if (month2 < 1 || month2 > 12) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid month. Please enter a valid month between 1 and 12.");
            }
        }


        // Prompt the user to input a month and year
        /*int year = 0;
        while (year < 1800 || year > 2023) {
            System.out.print("Enter year (1800-2023): ");
            year = scanner.nextInt();
        }
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        scanner.close();*/

        // Print the calendar for the month and year
        LocalDate date = LocalDate.of(year, month2, 1);
        DateTimeFormatter monthNameFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        System.out.println(date.format(monthNameFormatter));
        System.out.println("Su Mo Tu We Th Fr Sa");
        int daysInMonth = date.lengthOfMonth();
        int firstDayOfWeek = date.getDayOfWeek().getValue() % 7;
        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < firstDayOfWeek) {
                    System.out.print("   ");
                } else if (day > daysInMonth) {
                    System.out.print("   ");
                } else {
                    date = LocalDate.of(year, month2, day);
                    String holidayName = holidays.get(date);
                    if (holidayName != null) {
                        System.out.print("\u001B[93m");
                    } else if (j == 0 || j == 6) {
                        System.out.print("\u001B[91m");
                    }
                    System.out.printf("%2d ", day);
                    if (holidayName != null || j == 0 || j == 6) {
                        System.out.print("\u001B[0m");
                    }
                    day++;
                }
            }
            System.out.println();
        }

        // Print all the holidays for the year
        System.out.println("Holidays:");
        for (LocalDate holidayDate : holidays.keySet()) {
            if (holidayDate.getMonth().equals(month2) ) {
                String holidayName = holidays.get(holidayDate);
                System.out.println(holidayDate.format(DateTimeFormatter.ofPattern("MMM d")) + " - " + holidayName);
            }
        }
    }

}
