package Day5;

public class Student {
    String name;
    int rollNo;
    int age;

    // Constructor
    Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    // toString method for easy display
    public String toString() {
        return "Name: " + name + ",Roll No: " + rollNo + ", Age: " + age;
        		
        
    }
}


