import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        int number = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the numbers you want to sum: ");
        int a = scan.nextInt();


        File file = new File("data.txt");
        try {
            FileOutputStream outfile = new FileOutputStream(file);
            PrintStream outputPrint = new PrintStream(outfile);

            for (int i = 1; i <= a; i++) {
                System.out.print("enter " + i + " number you want to add: ");
                number = scan.nextInt();

                outputPrint.println(number);
                total += number;
            }
            outputPrint.close();
            System.out.println("--------------------------");
            System.out.println("Sum of entered numbers: " + total);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileRead = new FileReader(file);
            BufferedReader buffRead = new BufferedReader(fileRead);
            String line;
            System.out.println("--------------------------");
            System.out.println("Your values in the database: ");
            while ((line = buffRead.readLine()) != null) {
                System.out.println(line);


            }
            buffRead.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}