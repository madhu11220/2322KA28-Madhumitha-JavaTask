package Day4;
import java.io.*;
import java.util.*;

public class EmployeeCRUD {

      static final String FILE_NAME = "employees.txt";

	    public static void main(String[] args) throws IOException {
	        Scanner sc = new Scanner(System.in);
	        while (true) {
	            System.out.println("\n1. Add Employee\n2. View Employees\n3. Update Employee\n4. Delete Employee\n5. Exit");
	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1 -> addEmployee(sc);
	                case 2 -> viewEmployees();
	                case 3 -> updateEmployee(sc);
	                case 4 -> deleteEmployee(sc);
	                case 5 -> {
	                    System.out.println("Exiting...GoodBye");
	                    return;
	                }
	                default -> System.out.println("Invalid choice.");
	            }
	        }
	    }

	    static void addEmployee(Scanner sc) throws IOException {
	        System.out.print("Enter Employee ID, Name, Designation: ");
	        String data = sc.nextLine();
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
	            bw.write(data);
	            bw.newLine();
	        }
	    }

	    static void viewEmployees() throws IOException {
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            System.out.println("\n--- Employee Records ---");
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
	        }
	    }

	    static void updateEmployee(Scanner sc) throws IOException {
	        System.out.print("Enter Employee ID to update: ");
	        String id = sc.nextLine();
	        List<String> lines = new ArrayList<>();
	        boolean updated = false;

	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                if (line.startsWith(id + ",")) {
	                    System.out.print("Enter new record (ID, Name, Designation): ");
	                    lines.add(sc.nextLine());
	                    updated = true;
	                } else {
	                    lines.add(line);
	                }
	            }
	        }

	        if (updated) {
	            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
	                for (String l : lines) {
	                    bw.write(l);
	                    bw.newLine();
	                }
	            }
	            System.out.println("Employee updated successfully.");
	        } else {
	            System.out.println("Employee ID not found.");
	        }
	    }

	    static void deleteEmployee(Scanner sc) throws IOException {
	        System.out.print("Enter Employee ID to delete: ");
	        String id = sc.nextLine();
	        List<String> lines = new ArrayList<>();
	        boolean deleted = false;

	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                if (!line.startsWith(id + ",")) {
	                    lines.add(line);
	                } else {
	                    deleted = true;
	                }
	            }
	        }

	        if (deleted) {
	            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
	                for (String l : lines) {
	                    bw.write(l);
	                    bw.newLine();
	                }
	            }
	            System.out.println("Employee deleted successfully.");
	        } else {
	            System.out.println("Employee ID not found.");
	        }
	    }
	}
