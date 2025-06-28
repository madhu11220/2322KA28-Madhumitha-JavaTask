package Day5;
import java.util.*;

import java.util.*;

/** POJO with minimal encapsulation */
 class Student {
    private final int id;
    private final String name;
    private final List<String> courses = new ArrayList<>();

    Student(int id, String name) {
        this.id   = id;
        this.name = name;
    }
    /* ---------- business methods ---------- */
    public boolean addCourse(String course) {
        if (!courses.contains(course)) {
            return courses.add(course);
        }
        return false;
    }
    public boolean removeCourse(String course) {
        return courses.removeIf(c -> c.equalsIgnoreCase(course));
    }

    /* ---------- getters ---------- */
    public int getId()             { return id; }
    public String getName()        { return name; }
    public List<String> getCourses() { return Collections.unmodifiableList(courses); }

    @Override
    public String toString() {
        return "Student ID: " + id +
               "\nName      : " + name +
               "\nCourses   : " + courses;
    }
}

public class StudentManagementApp {

    private static final Map<Integer, Student> students = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);

    /* --------------- main --------------- */
    public static void main(String[] args) {
        while (true) {
            switch (menu()) {
                case 1  -> addStudent();
                case 2  -> searchStudent();
                case 3  -> deleteStudent();
                case 4  -> deleteCourse();
                case 5  -> displayAll();
                case 6  -> { System.out.println("👋 Program terminated."); return; }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    /* --------------- menu helper --------------- */
    private static int menu() {
        System.out.println("\n=== Student Management Menu ===");
        System.out.println("1. Add Student and Courses");
        System.out.println("2. Search Student by ID");
        System.out.println("3. Delete Student");
        System.out.println("4. Delete Course from Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Exit");
        return readInt("Enter your choice: ");
    }

    /* --------------- operations --------------- */
    private static void addStudent() {
        int id = readInt("Enter Student ID: ");
        if (students.containsKey(id)) {
            System.out.println("⚠️  ID already exists.");
            return;
        }
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        Student s = new Student(id, name);

        System.out.println("Enter course names (type 'done' to finish):");
        while (true) {
            String course = sc.nextLine().trim();
            if (course.equalsIgnoreCase("done")) break;
            s.addCourse(course);
        }
        students.put(id, s);
        System.out.println("✅ Student added!");
    }

    private static void searchStudent() {
        int id = readInt("Enter Student ID to search: ");
        Student s = students.get(id);
        System.out.println(s != null ? ("\n🎓 Found:\n" + s) : "❌ Student not found.");
    }

    private static void deleteStudent() {
        int id = readInt("Enter Student ID to delete: ");
        System.out.println(students.remove(id) != null
                ? "✅ Student deleted." : "❌ Student not found.");
    }

    private static void deleteCourse() {
        int id = readInt("Enter Student ID: ");
        Student s = students.get(id);
        if (s == null) {
            System.out.println("❌ Student not found.");
            return;
        }
        System.out.print("Enter course name to remove: ");
        String course = sc.nextLine().trim();
        System.out.println(s.removeCourse(course)
                ? "✅ Course removed." : "⚠️  Course not found for this student.");
    }

    private static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("⚠️  No students recorded.");
            return;
        }
        System.out.println("\n--- All Enrolled Students ---");
        students.values().forEach(s -> {
            System.out.println(s);
            System.out.println("-".repeat(30));
        });
    }

    /* --------------- utility --------------- */
    private static int readInt(String prompt) {
        int num;
        while (true) {
            System.out.print(prompt);
            try {
                num = Integer.parseInt(sc.nextLine().trim());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
