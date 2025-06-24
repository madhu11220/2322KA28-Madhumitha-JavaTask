package Day1;

import java.util.Scanner;

public class Calculator {
	
	public static void main(String[] args){

	Scanner sc = new Scanner(System.in);

	System.out.println("Enter the principle:");

	double p= sc.nextDouble();

	System.out.println("No of Years:");

	double n = sc.nextDouble();

	System.out.println("rate:");

	double r = sc.nextDouble();

	if(p>0&&n>0&&r>0){

	double percent = ((p*n*r)/100);

	System.out.println("Simple interest percentage:"+percent);

	}
  }
}
