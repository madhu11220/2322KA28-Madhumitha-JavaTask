package Day5;

   
	import java.util.*;

	// Student class definition
	public class EnrollmentManager {
	static class Student {
	    int id;
	    String name;

	    Student(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    // Equals and hashCode for HashMap key usage
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Student)) return false;
	        Student other = (Student) o;
	        return id == other.id && name.equals(other.name);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id, name);
	    }

	    @Override
	    public String toString() {
	        return id + " - " + name;
	    }
	}

	// Main class with a different name
	
	    static ArrayList<Student> studentList = new ArrayList<>();
	    static HashMap<Student, ArrayList<String>> courseMap = new HashMap<>();
	    static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        int choice;

	        do {
	            System.out.println("\n=== Student Course Enrollment ===");
	            System.out.println("1. Add Student and Courses");
	            System.out.println("2. Remove Student");
	            System.out.println("3. Display All Enrollments");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1 -> addStudentWithCourses();
	                case 2 -> removeStudentById();
	                case 3 -> displayEnrollments();
	                case 4 -> System.out.println("Exiting the program....Goodbye");
	                default -> System.out.println("Invalid choice, try again.");
	            }
	        } while (choice != 4);
	    }

	    static void addStudentWithCourses() {
	        System.out.print("Enter Student ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Enter Student Name: ");
	        String name = sc.nextLine();

	        Student student = new Student(id, name);
	        studentList.add(student);

	        ArrayList<String> courses = new ArrayList<>();
	        System.out.print("Enter number of courses to enroll: ");
	        int n = sc.nextInt();
	        sc.nextLine();

	        for (int i = 1; i <= n; i++) {
	            System.out.print("Enter course " + i + ": ");
	            courses.add(sc.nextLine());
	        }

	        courseMap.put(student, courses);
	        System.out.println("✅ Student added and courses enrolled.");
	    }

	    static void removeStudentById() {
	        System.out.print("Enter Student ID to remove: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        Iterator<Student> iterator = studentList.iterator();
	        boolean found = false;

	        while (iterator.hasNext()) {
	            Student s = iterator.next();
	            if (s.id == id) {
	                iterator.remove();
	                courseMap.remove(s);
	                System.out.println("✅ Student removed.");
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("❌ Student not found.");
	        }
	    }

	    static void displayEnrollments() {
	        if (studentList.isEmpty()) {
	            System.out.println("⚠️ No students enrolled yet.");
	            return;
	        }

	        System.out.println("\n--- Enrolled Students and Courses ---");
	        Iterator<Student> studentIterator = studentList.iterator();

	        while (studentIterator.hasNext()) {
	            Student student = studentIterator.next();
	            System.out.println("Student: " + student);
	            ArrayList<String> courses = courseMap.get(student);

	            if (courses != null && !courses.isEmpty()) {
	                Iterator<String> courseIterator = courses.iterator();
	                while (courseIterator.hasNext()) {
	                    System.out.println("  - " + courseIterator.next());
	                }
	            } else {
	                System.out.println("  No courses enrolled.");
	            }
	        }
	    }
	}



