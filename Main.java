/*********************************************************************************************************
 * CLASS: Main (Main.java)
 *
 * DESCRIPTION
 * Program determines how many runs up and runs down are in a given data set.
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
import java.util.ArrayList;
import java.lang.Integer;

public class Main {
    public static void main(String[] pArgs){
        new Main().run();
    }

    private void run(){
        // ArrayList for contents of the file
        ArrayList<Integer> list = new ArrayList<>();

        // Variable for input file name
        String inFileName = "p1-in.txt";

        // Try catch block for reading file
        try {
            list = readInputFile(inFileName);
        }
        catch (FileNotFoundException pException){
            System.out.printf("Oops, could not open '%s' for reading. The program is ending.\n", inFileName);
            System.exit(-100);
        }

        // 1 signifies RUNS_UP
        ArrayList<Integer> listRunsUpCount = findRuns(list, 1);
        // -1 signifies RUNS_DN
        ArrayList<Integer> listRunsDnCount = findRuns(list, -1);

        // Stores the total runs at each index in the ArrayList listRunsCount
        ArrayList<Integer> listRunsCount = mergeLists(listRunsUpCount, listRunsDnCount);


        String outFileName = "p1-runs.txt";
        try {
            writeOutputFile(outFileName, listRunsCount);
        }
        catch (FileNotFoundException pException){
            System.out.printf("Oops, could not open '%s' for writing. The program is ending.\n", outFileName);
            System.exit(-200);
        }

    } // end run()


    /**
     * The findRuns method iterates through the ArrayList data set and counts how many runs there are
     * */
    public ArrayList<Integer> findRuns(ArrayList<Integer> pList, int pDir){
        ArrayList<Integer> listRunsCount  = arrayListCreate(pList.size(), 0);
        int i = 0, k = 0;

        while(i < pList.size() - 1){
            // Increment k if pDir is RUNS_UP
            if (pDir == 1 && pList.get(i) <= pList.get(i + 1)){
                k++;
            }
            // Increment k if pDir is RUNS_DN
            else if (pDir == -1 && pList.get(i) >= pList.get(i + 1)){
                k++;
            }
            else {
                if (k != 0){
                    // Increment the element at index k of listRunsCount
                    listRunsCount.set(k, listRunsCount.get(k) + 1);
                    k = 0;
                }
            }

            i++;
        } // end while

        if (k != 0){
            // Increment the element at index k of listRunsCount
            listRunsCount.set(k, listRunsCount.get(k) + 1);
        }

        return listRunsCount;
    } // end findRuns()

    /**
     * The mergeLists method combines the amount of runs up and runs down into one cumulative total at each index
     * */
    public ArrayList<Integer> mergeLists(ArrayList<Integer> pListRunsUpCount, ArrayList<Integer> pListRunsDnCount){
        ArrayList<Integer> listRunsCount = arrayListCreate(pListRunsUpCount.size(), 0);
        for (int i = 0; i < pListRunsUpCount.size() - 1; i ++){
            // Set element i of listRunsCount to the sum of the elements at i in pListRunsUpCount and pListRunsDnCount
            listRunsCount.set(i, pListRunsUpCount.get(i) + pListRunsDnCount.get(i));
        }

        return listRunsCount;
    } // end mergeLists

    /**
     * The arrayListCreate method creates an ArrayList of size pSize and initializes all elements with pInitValue
     * */
    public ArrayList<Integer> arrayListCreate(int pSize, int pInitValue){
        ArrayList<Integer> list = new ArrayList<>();
        // Initialize all elements in the ArrayList to pInitValue
        for (int i = 0;  i < pSize; i++){
            list.add(pInitValue);
        }
        return list;
    } // end arrayListCreate()


    /**
     * The writeOutputFile method writes the amount total amount of runs at each index into the specified file
     * */
    public void writeOutputFile(String pFileName, ArrayList<Integer> pListRuns) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(pFileName);
        // Determine the amount of TOTAL runs
        int runsTotal = 0;
        for (Integer pListRun : pListRuns){
            runsTotal += pListRun;
        }
        out.printf("runs_total: %d\n", runsTotal);

        // Print the amount of runs at each index
        for (int k = 1; k < pListRuns.size(); k++){
            out.printf("runs_%d: %d\n", k, pListRuns.get(k));
        }

        out.close();
    } // end writeOutputFile

    /**
     * The readInputFile method reads the file that is passed and adds the integers in the file to the ArrayList list
     * */
    public ArrayList<Integer> readInputFile(String pFileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(pFileName));
        ArrayList<Integer> list = new ArrayList<>();

        // Add integers in the file to the ArrayList
        while(in.hasNextInt()){
            int num = in.nextInt();
            list.add(num);
        }
        in.close();
        return list;
    } // end readInputFile
} // end Main
