package Practice;
import java.util.Scanner;
public class ScannerExample {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your Name");
        String name = scanner.nextLine();
        System.out.println("Hello "+name);
    }
}
