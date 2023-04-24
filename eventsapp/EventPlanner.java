package eventsapp;

import java.io.*;
import java.util.Scanner;

public class EventPlanner {
    private static final String FILENAME = "NewQeury/events.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String eventName;
        String eventDate;
        String eventTime;
        boolean repeat = false;

        do {
            // Ask the user for event details
            System.out.print("Enter the event name: ");
            eventName = scanner.nextLine();
            System.out.print("Enter the event date (MM/DD/YYYY): ");
            eventDate = scanner.nextLine();
            System.out.print("Enter the event time (HH:MM AM/PM): ");
            eventTime = scanner.nextLine();

            // Save the event to a text file
            saveEventToFile(eventName, eventDate, eventTime);

            // Ask the user if they want to repeat
            System.out.print("\nDo you want to enter another event? (Y/N): ");
            String repeatInput = scanner.nextLine();
            repeat = repeatInput.equalsIgnoreCase("Y");
        } while (repeat);

        // Read and print out the events.txt from the text file
        System.out.println("\nEvent List:");
        printEventsFromFile();

        System.out.println("\nThanks for using the event planner!");
    }

    private static void saveEventToFile(String name, String date, String time) {
        try (FileWriter fw = new FileWriter(FILENAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(name + "," + date + "," + time);
        } catch (IOException e) {
            System.err.println("Error saving event to file: " + e.getMessage());
        }
    }

    private static void printEventsFromFile() {
        try (FileReader fr = new FileReader(FILENAME);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("Name: " + parts[0]);
                System.out.println("Date: " + parts[1]);
                System.out.println("Time: " + parts[2]);
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading events.txt from file: " + e.getMessage());
        }
    }
}
