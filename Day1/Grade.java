package Day1;
	import java.util.Scanner;

	public class Grade {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	int marks;

	while (true) {

	System.out.println("Enter the marks:");

	marks = sc.nextInt();

	if (marks >= 0 && marks <= 100) {

	break;

	}else{

	System.out.println("Invalid marks");

	}

	}

	System.out.println("Grade:" +getGrade(marks));
	

	}

	static String getGrade (int marks) {

	if(marks >= 90)

		return "A";
	else if(marks >= 80)

	  return "B";

	else if(marks >= 70)

	return "C";

	else if(marks >= 60)

	return "D";

	else

	return "Fail";



	}

	}

