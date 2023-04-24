package writeandreadfromfile;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HolidayCalendar {

    public static void main(String[] args) {
        System.out.println("Welcome to the Holiday Calendar!");
        ranProgram();


    }
    public static void ranProgram(){
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a holiday");
            System.out.println("2. View holidays");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            int choice = input.nextInt();

            if (choice == 1) {
                addHoliday();
            } else if (choice == 2) {
                File file = new File("holidays.txt");

                if (file.exists()) {
                    viewHolidays();
                }else {
                    try {
                        file.createNewFile();
                        System.out.println("No holidays saved yet.....for now.");
                        System.out.println("");
                        System.out.println("enter (y) if you want to add holidays\nenter (n) if you don't want");
                        String holidayInput = input.nextLine();
                        if(holidayInput.equals("y")){
                            addHoliday();
                        } else if (holidayInput.equals("n")) {
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addHoliday() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the holiday: ");
        String name = input.nextLine();

        System.out.print("Enter the date of the holiday (yyyy-mm-dd): ");
        String date = input.nextLine();

        try {
            File file = new File("holidays.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(name + "," + date + "\n");
            writer.close();
            System.out.println("Holiday added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding holiday to file.");
            e.printStackTrace();
        }
    }

    private static void viewHolidays() {
        Scanner input = new Scanner(System.in);

        try {
            File file = new File("holidays.txt");
            Scanner reader = new Scanner(file);

            if (reader.hasNextLine()) {
                System.out.println("\nHolidays:\n");

                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] parts = line.split(",");

                    String name = parts[0];
                    String date = parts[1];

                    System.out.println(name + " - " + date);
                }
            } else {
                System.out.println("\nNo holidays to display.");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading holidays from file.");
            e.printStackTrace();
        }
    }
    private static void checkHolidays() {
        Scanner input = new Scanner(System.in);

        try {
            File file = new File("holidays.txt");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("No holidays saved yet.");
                return;
            }
            Scanner reader = new Scanner(file);

            if (reader.hasNextLine()) {
                System.out.println("\nHolidays:\n");

                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] parts = line.split(",");

                    String name = parts[0];
                    String date = parts[1];

                    System.out.println(name + " - " + date);
                }
            } else {
                System.out.println("\nNo holidays to display.");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading holidays from file.");
            e.printStackTrace();
        }
    }

}
