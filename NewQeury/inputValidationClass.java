package NewQeury;

import java.util.Scanner;

public class inputValidationClass {
    public void inputValidationGeneralMethod(){
        //inputValidationMethod
        Scanner scanner = new Scanner(System.in);

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

    }
    public void extraInputValidationForDay(){
        Scanner scanner = new Scanner(System.in);
        int day = 0;
        while (true) {
            System.out.print("Enter day (1-31): ");
            try {
                day = scanner.nextInt();
                //day = Integer.parseInt(input.nextLine());
                if (day < 1 || day > 31) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid day. Please enter a valid day between 1 and 31.");
            }
        }
    }
}
