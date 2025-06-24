package Day2;


	import java.util.Scanner;
	
	public class AddressBook {
		

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int maxContacts = 5; 
	        String[] names = new String[maxContacts];
	        String[] phoneNumbers = new String[maxContacts];
	        String[] emails = new String[maxContacts];

	        int contactCount = 0;

	        while (true) {
	            System.out.println("\nAddress Book Menu:");
	            System.out.println("1. Add Contact");
	            System.out.println("2. Display Contacts");
	            System.out.println("3. Exit");
	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    if (contactCount < maxContacts) {
	                        System.out.print("Enter Name: ");
	                        names[contactCount] = sc.nextLine();

	                        System.out.print("Enter Phone Number: ");
	                        phoneNumbers[contactCount] = sc.nextLine();

	                        System.out.print("Enter Email: ");
	                        emails[contactCount] = sc.nextLine();

	                        contactCount++;
	                        System.out.println("Contact added successfully!");
	                    } else {
	                        System.out.println("Address book is full!");
	                    }
	                    break;

	                case 2:
	                    if (contactCount == 0) {
	                        System.out.println("No contacts to display.");
	                    } else {
	                        System.out.println("\n--- Contacts ---");
	                        for (int i = 0; i < contactCount; i++) {
	                            System.out.println("Contact " + (i + 1));
	                            System.out.println("Name: " + names[i]);
	                            System.out.println("Phone: " + phoneNumbers[i]);
	                            System.out.println("Email: " + emails[i]);
	                            System.out.println("------------------------");
	                        }
	                    }
	                    break;

	                case 3:
	                    System.out.println("Exiting.. Goodbye!");
	                    return;

	                default:
	                    System.out.println("Invalid option");
	            }
	        }
	    }
	}



