package Day5;

import java.util.HashSet;
import java.util.Iterator;

	public class UniqueEmails {
	    public static void main(String[] args) {
	        // Creating a HashSet to store unique email addresses
	        HashSet<String> emailSet = new HashSet<>();

	        // Adding emails (duplicates will be ignored)
	        emailSet.add("alice@example.com");
	        emailSet.add("bob@example.com");
	        emailSet.add("charlie@example.com");
	        emailSet.add("alice@example.com");  // Duplicate
	        emailSet.add("dave@example.com");

	        // Displaying emails using Iterator
	        System.out.println("Unique Email Addresses:");
	        Iterator<String> iterator = emailSet.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	        }
	    }
	}


	


