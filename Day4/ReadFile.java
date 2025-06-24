package Day4;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            String line;
            System.out.println(" Contents of input.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found. Make sure input.txt exists.");
        } catch (IOException e) {
            System.out.println("❌ Error reading the file: " + e.getMessage());
        }
    }
}

