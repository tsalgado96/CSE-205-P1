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
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Integer;

public class Main {
    public static void main(String[] pArgs){
        new Main().run();
    }

    private void run(){
        // ArrayList for contents of the file
        ArrayList<Integer> list = new ArrayList<>();

        // User inputs the name of the file
//        Scanner input = new Scanner((System.in));
//        System.out.print("Please enter file name: ");
//        String fileName = input.next();

        // Hardcoded file name for testing
        String fileName = "p1-in.txt";

        // Try catch block for reading file
        try {
            list = readInputFile(fileName);
        }
        catch (FileNotFoundException pException){
            System.out.printf("Oops, could not open '%s' for reading. The program is ending.", fileName);
            System.exit(-100);
        }

        ArrayList<Integer> listRunsUpCount = new ArrayList<>();
        ArrayList<Integer> listRunsDnCount = new ArrayList<>();

        // 1 signifies RUNS_UP
        findRuns(list, 1);
        // -1 signifies RUNS_DN
        findRuns(list, -1);

    } // end run()


    public ArrayList<Integer> findRuns(ArrayList<Integer> pList, int pDir){
        ArrayList<Integer> listRunsCount  = arrayListCreate(pList.size(), 0);
        int i = 0, k = 0;

        while(i < pList.size()){
            if (pDir == 1 && pList.get(i) <= pList.get(i + 1)){
                k++;
            }
            else if (pDir == -1 && pList.get(i) >= pList.get(i)){
                k++;
            }
            else {
                if (k != 0){

                }
            }

            i++;
        }
    } // end findRuns()


    public ArrayList<Integer> arrayListCreate(int pSize, int pInitValue){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;  i < pSize; i++){
            list.add(pInitValue);
        }
        return list;
    } // end arrayListCreate()

    // Read the file that is passed and add integers to the ArrayList list
    public ArrayList<Integer> readInputFile(String pFileName) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(pFileName));
        ArrayList<Integer> list = new ArrayList<>();

        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            list.add(num);
        }
        return list;
    } // end readInputFile
} // end Main
