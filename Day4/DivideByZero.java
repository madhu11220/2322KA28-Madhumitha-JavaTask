package Day4;

public class DivideByZero {
	 
	    public static void main(String[] args) {
	        try {
	            int a = 10, b = 2;
	            int result = a / b;
	            System.out.println("Result: " + result);
	        } catch (ArithmeticException e) {
	            System.out.println("Error: Cannot divide by zero.");
	        }
	    }
	}



