/*********************************************************************************************************
 * CLASS: Main (Main.java)
 *
 * DESCRIPTION
 * A description of the contents of this file.
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Spring 2021
 * Project Number: 1
 *
 * GROUP INFORMATION
 * AUTHOR 1: Teodoro Salgado, tjsalgad, tsalgado96@gmail.com
 * AUTHOR 2: Isaac Pena, ipena5, ippenaisaac@gmail.com
 * AUTHOR 3: Stephen Elledge, saelledg, saelledg@asu.edu
 ********************************************************************************************************/
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] pArgs) {
        new Main().run();
    }

    private void run(){
        // User inputs the name of the file
//        Scanner input = new Scanner((System.in));
//        System.out.print("Please enter file name: ");
//        String fileName = input.next();

        // Hardcoded file name for testing
        String fileName = "p1-in.txt";

        try{
            Scanner scanner = new Scanner(new File(fileName));

        }
        catch (FileNotFoundException pException){
            System.out.printf("Oops, could not open '%s' for reading. The program is ending.", fileName);
        }

    };
}
