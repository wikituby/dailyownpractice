package NewQeury;

import java.util.Scanner;

public class CalendarProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please chose an option ");

        String homeView = """
                          1. Go To Date
                          2. View Month
                          3. View Year
                          4. View Random Holidays
                          5. View Holiday for Months
                          0. Exit
                          """;
        System.out.println(homeView);
        int mySwitch = scanner.nextInt();
        switch (mySwitch){
            case 1 -> {
                GoToDate myGoToDateObject = new GoToDate();
                myGoToDateObject.myGoToDate();            }
            case 2 ->{
                MonthView myMonthViewObject = new MonthView();
                myMonthViewObject.monthView();
            }
            case 3 ->{
                YearCalendar myYearCalenderObject = new YearCalendar();
                myYearCalenderObject.yearCalendar();
            }
            case 4 ->{
                HolidayFinder myHolidayFinderObject = new HolidayFinder();
                myHolidayFinderObject.holidayFinder();
            }
            case 5 ->{
                HolidayCalendar myHolidayObject = new HolidayCalendar();
                myHolidayObject.myHolidayCalendar();
            }
            default -> throw new IllegalArgumentException("Invalid Input please try again: " + mySwitch);


        }

    }
}