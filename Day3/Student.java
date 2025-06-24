package Day3;

import java.util.Scanner;

	public class Student {
	    String name;
	    int rollNo;
	    int[] marks = new int[3];  
	    
	    public void inputDetails(Scanner sc) {
	        System.out.print("Enter name: ");
	        name = sc.nextLine();
	        System.out.print("Enter roll number: ");
	        rollNo = sc.nextInt();
	        System.out.println("Enter marks for 3 subjects:");
	        for (int i = 0; i < 3; i++) {
	            marks[i] = sc.nextInt();
	        }
	        sc.nextLine();  
	    }

	   
	    public void displayResult() {
	        int total = 0;
	        for (int m : marks) {
	            total += m;
	        }
	        double average = total / 3.0;
	        System.out.println("\n--- Student Report ---");
	        System.out.println("Name: " + name);
	        System.out.println("Roll No: " + rollNo);
	        System.out.println("Total Marks: " + total);
	        System.out.println("Average: " + average);
	        System.out.println("Result: " + (average >= 35 ? "Pass" : "Fail"));
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Student s = new Student();
	        s.inputDetails(sc);
	        s.displayResult();
	        
	    }
	}



