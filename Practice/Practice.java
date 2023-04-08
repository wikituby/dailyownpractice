package Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.HashSet;
import java.util.Set;
public class Practice {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("hony");
        names.add("john");
        names.add("henry");

        System.out.println(names);

        String s =("Home");
        String s1="Java is a programming language. Java is a platform. Java is an Island.";

        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.startsWith("d"));
        System.out.println(s.endsWith("g"));
        System.out.println(s.endsWith("e"));
        System.out.println(s.charAt(2));
        System.out.println(s.length());
        String replaceString=s1.replace("Java","Kava");//replaces all occurrences of "Java" to "Kava"
        System.out.println(replaceString);

        int x=5;
        String st = String.valueOf(x);
        System.out.println(st+5);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Janie");
        list.add("John");
        list.add("Jan");
        list.add("Julius");

        Stack<String> stack = new Stack<String>();
        stack.push("Ayush");
        stack.push("Garvit");
        stack.push("Amit");
        stack.push("Ashish");
        stack.push("Garima");
        stack.pop();
        Iterator<String> itr=stack.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        ArrayList<String> name = new ArrayList<>();
        name.add("Joan");
        name.add("Joan2");
        name.add("Joan3");
        name.add("Joan4");
        name.add("Joan5");
        name.add("Joan6");
        name.add("Joan7");

        Iterator<String> iter = name.iterator();
        while (iter.hasNext()) {
            String name2 = iter.next();
            System.out.println(name);
        }

            }
        }