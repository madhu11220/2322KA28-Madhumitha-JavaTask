package Day5;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {

	     public static void main(String[] args) {
	        // Creating ArrayList of Students
	        ArrayList<Student> students = new ArrayList<>();

	        // Adding student objects
	        students.add(new Student("Charles", 1, 21));
	        students.add(new Student("Alice", 2, 22));
	        students.add(new Student("Henry",3, 23));
	        		
	        // Display using Iterator
	        Iterator<Student> iterator = students.iterator();
	        
	        System.out.println("Student List:");
	        while (iterator.hasNext()) {
	            Student s = iterator.next();
	            System.out.println(s);  // Calls toString method
	        }
	    }
	}