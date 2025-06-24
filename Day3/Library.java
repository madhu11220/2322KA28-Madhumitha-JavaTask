package Day3;

import java.util.*;

class Library {
    ArrayList<String> books = new ArrayList<>();

    //add books
    public void addBook(String book) {
        books.add(book);
        System.out.println("\"" + book + "\" added to the library.");
    }

   //remove books 
    public void removeBook(String book) {
        if (books.remove(book)) {
            System.out.println("\"" + book + "\" removed from the library.");
        } else {
            System.out.println("\"" + book + "\" not found.");
        }
    }

    //issue books
    public void issueBook(String book) {
        if (books.contains(book)) {
            books.remove(book);
            System.out.println("\"" + book + "\" has been issued.");
        } else {
            System.out.println("\"" + book + "\" is not available.");
        }
    }

    //show books
    public void showBooks() {
        System.out.println("\nAvailable books:");
        for (String b : books) {
            System.out.println("- " + b);
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("Java Programming");
        lib.addBook("Data Structures");
        lib.showBooks();

        lib.issueBook("Java Programming");
        lib.showBooks();

        lib.removeBook("Data Structures");
        lib.showBooks();
    }
}

