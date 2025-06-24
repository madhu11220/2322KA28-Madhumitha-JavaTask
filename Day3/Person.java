package Day3;

public class Person {
	
	

	    String name;
	    int age;
	    String gender;

	    
	    public Person(String name, int age, String gender) {
	        this.name = name;
	        this.age = age;
	        this.gender = gender;
	    }

	    
	    public void displayPersonInfo() {
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	        System.out.println("Gender: " + gender);
	    }
	}

	
	class Employee extends Person {
	    String employeeId;
	    double basicSalary;

	   
	    public Employee(String name, int age, String gender, String employeeId, double basicSalary) {
	        super(name, age, gender);
	        this.employeeId = employeeId;
	        this.basicSalary = basicSalary;
	    }

	    	    public double calculateHRA() {
	        return 0.20 * basicSalary;  
	    }

	   
	    public double calculateDA() {
	        return 0.10 * basicSalary;  
	    }

	    
	    public double calculatePF() {
	        return 0.08 * basicSalary;  
	    }

	    
	    public double calculateGrossSalary() {
	        return basicSalary + calculateHRA() + calculateDA();
	    }

	    	    public double calculateNetSalary() {
	        return calculateGrossSalary() - calculatePF();
	    }

	    
	    public void displayEmployeeDetails() {
	        displayPersonInfo();
	        System.out.println("Employee ID: " + employeeId);
	        System.out.println("Basic Salary: ₹" + basicSalary);
	        System.out.println("HRA (20%): ₹" + calculateHRA());
	        System.out.println("DA (10%): ₹" + calculateDA());
	        System.out.println("PF (8%): ₹" + calculatePF());
	        System.out.println("Gross Salary: ₹" + calculateGrossSalary());
	        System.out.println("Net Salary: ₹" + calculateNetSalary());
	    }
	}


	

