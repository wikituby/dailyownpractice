package Practice;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create a new ArrayList of integers
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Add some integers to the ArrayList
        numbers.add(5);
        numbers.add(10);
        numbers.add(15);

        // Print the contents of the ArrayList
        System.out.println("ArrayList: " + numbers);

        // Get the size of the ArrayList
        System.out.println("Size of ArrayList: " + numbers.size());

        // Retrieve an element from the ArrayList
        int firstNumber = numbers.get(0);
        System.out.println("First element: " + firstNumber);

        // Remove an element from the ArrayList
        numbers.remove(1);
        System.out.println("ArrayList after removing element at index 1: " + numbers);

        // Check if the ArrayList contains an element
        boolean containsTen = numbers.contains(10);
        System.out.println("ArrayList contains 10: " + containsTen);

        // Clear the contents of the ArrayList
        numbers.clear();
        System.out.println("ArrayList after clearing: " + numbers);
    }
}
