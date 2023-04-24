package writeandreadfromfile;

import java.io.FileWriter;
import java.io.IOException;

public class OwnFileWriter {
    public static void main(String[] args) {
        try {
            FileWriter myFileWriterObject = new FileWriter("myFile.txt");
            myFileWriterObject.write("Hello world");
            myFileWriterObject.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("Error occurred while creating and writing into file");
            e.printStackTrace();
        }
    }
}
