import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //get text from user
        System.out.print("Enter the text you want to write:  ");
        String text = scan.nextLine();

        //Create file
        File file = new File("data.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);  // Write on file
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(text);                                  // Print the entered text
            printWriter.close();
            System.out.println("--------------------------");
            System.out.println("Texts created in the database: ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileRead = new FileReader(file);               // Read on file
            BufferedReader buffRead = new BufferedReader(fileRead);
            String line;

            while ((line = buffRead.readLine()) != null) {            // Return until the databse runs out
                System.out.println(line);


            }
            buffRead.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}