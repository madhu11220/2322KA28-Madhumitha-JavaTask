package Day4;

import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        String[] lines = {
            "This is line 1.",
            "This is line 2.",
            "Java is a programming language"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

