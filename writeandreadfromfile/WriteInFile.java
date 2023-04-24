package writeandreadfromfile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class WriteInFile {
    public static void main(String[] args) {
        write();
        read();

    }

    public static void write() {
        try {
            FileWriter writer = new FileWriter("filename.txt");
            writer.write("Hello, World!");
            writer.close();
            System.out.println("Successfully wrote to the file...");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void read() {
        try {
            System.out.println("trying to read what is in the file...");
            File file = new File("filename.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
