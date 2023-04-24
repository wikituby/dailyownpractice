package writeandreadfromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarApp {

    private static final String FILENAME = "NewQeury/events.txt";

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        // Read events from file and add them to the calendar
        try (Scanner fileScanner = new Scanner(new File(FILENAME))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String eventName = parts[0];
                String eventDateStr = parts[1];
                String eventTimeStr = parts[2];

                // Parse event date and time
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Calendar eventCalendar = Calendar.getInstance();
                eventCalendar.setTime(dateFormat.parse(eventDateStr + " " + eventTimeStr));

                // Add event to calendar
                int eventDay = eventCalendar.get(Calendar.DAY_OF_MONTH);
                int eventMonth = eventCalendar.get(Calendar.MONTH);
                int eventYear = eventCalendar.get(Calendar.YEAR);
                int eventHour = eventCalendar.get(Calendar.HOUR_OF_DAY);
                int eventMinute = eventCalendar.get(Calendar.MINUTE);
                calendar.set(eventYear, eventMonth, eventDay, eventHour, eventMinute);

                // Print event on calendar
                System.out.println(eventName + ": " + calendar.getTime());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading events from file: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Error parsing event date/time: " + e.getMessage());
        }
    }

}
