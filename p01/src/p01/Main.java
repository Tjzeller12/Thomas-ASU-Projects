package p01;
//********************************************************************************************************
//CLASS: Main (Main.java)
//
//DESCRIPTION this program reads a file with integers, finds each run(K value) for run ups and run downs, merges 
//them into one list, finds the total runs, then prints each run and the the total runs to a text file.
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, summer 2021
//Project Number: 01
//
//AUTHOR: Thomas Zeller, tjzeller, tjzeller@asu.edu, Michael Zeller, mrzeller, mrzeller@asu.edu
//********************************************************************************************************
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Main test1 = new Main();
		test1.run();

	}
	public Main() {	
	}
	/**
	 * This is where the program runs. It goes through each method tell the file has been written
	 */
	public void run() {
		try {//catches FileNotFoundException
		ArrayList<Integer> pList = readInputFile("p01-in.txt");//reads the file and creates a list of integers that were on the file
		ArrayList<Integer> RunUps = findRunsUp(pList);//finds all the run up k values from pList
		ArrayList<Integer> RunDowns = findRunsDown(pList);//finds all the run down k values from pList
		ArrayList<Integer> RunsUpKvalues = runsK_values(RunUps, pList);//finds sum of every different run up K value and adds it to a list
		ArrayList<Integer> RunsDownKvalues = runsK_values(RunDowns, pList);//finds sum of every different run up K value and adds it to a list
		ArrayList<Integer> mergeLists = mergeLists(RunsUpKvalues, RunsDownKvalues);//merges RunsUpKvalues and RunsDownKvalues(run_1, run_2, run_3, etc)
		int kSum = getKsum(mergeLists);//gets the sum of every element in mergeLists(total_runs)
		writeOutputFile("p01_runs.txt", mergeLists, kSum);//writes getKsum (total_runs) and every element in mergeLists(run_1, run_2, etc) to a text file
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
			System.exit(-100);
		}
	}
	/**
	 * Reads a file and stores all of the integers in that file into an array list
	 * @param pFilename this is the file name
	 * @return ArrayList of Integers contains every int on the input file
	 */
	public ArrayList<Integer> readInputFile(String pFilename) throws FileNotFoundException {//throws file not found to run() method
		ArrayList<Integer> inputFileNums = new ArrayList<>();
			Scanner inputNums = new Scanner(new File(pFilename));
			while(inputNums.hasNextInt()) {
				int num = inputNums.nextInt();
				inputFileNums.add(num);
			}
			inputNums.close();
		return inputFileNums;
	}
	/**
	 * stores every run up K value to a arrayList
	 * @param pList (the read file)
	 * @return ArrayList of integers containing the k values for all the run ups
	 * EX) if this is the argument {2, 8, 3, 2, 9, 8, 6, 3, 4, 6, 1, 9} then it will create a list of {1, 1, 2, 1}
	 */
	public ArrayList<Integer> findRunsUp(ArrayList<Integer> pList) {
		ArrayList<Integer> runsUp = new ArrayList<>();	
		int k = 1;
		for (int i = 1; i < pList.size(); i++) {//increments threw the list provided in the argument(the list we read from)
			if (pList.get(i) >= pList.get(i - 1)) {//if the current element is more then the previous element increment K
				k++;
				if(i == pList.size() - 1) {//this if statement allows the remaining K value to get stored to the ArrayList
					runsUp.add(k - 1);
				}
			} else {//if the current element is less then the previous element add (K - 1) to the list so we could get the proper K value added to the list
				runsUp.add(k - 1);
				k = 1;//resets K
			}	
		}
		return runsUp;
	}
	/**
	 * stores every run down K value to a arrayList
	 * @param pList (the read file)
	 * @return ArrayList of integers containing the k values for all the run downs
	 * EX) if this is the argument {2, 8, 3, 2, 9, 8, 6, 3, 4, 6, 1, 9} then it will create a list of {2, 3, 1}
	 */
	public ArrayList<Integer> findRunsDown(ArrayList<Integer> pList) {
		ArrayList<Integer> runsDown = new ArrayList<>();	
		int k = 1;
		for (int i = 1; i < pList.size(); i++) {//increments threw the list provided in the argument(the list we read from)
			if (pList.get(i) <= pList.get(i - 1)) {//if the current element is less then the previous element increment K
				k++;
				if(i == pList.size() - 1) {//this if statement allows the remaining K value to get stored to the ArrayList
					runsDown.add(k - 1);
				}
			} else {//if the current element is more then the previous element add (K - 1) to the list so we could get the proper K value added to the list
				runsDown.add(k - 1);
				k = 1;
			}
		}
		return runsDown;
	}
	/**
	 * This calculates the sum of every different K value that is in a list
	 * @param runs (this is the list of K values for run ups and the list for run downs)
	 * @param pList (we use this for the length of the list)
	 * @return Array list of the sum of every different K value
	 * EX: if we use findRunsUp as the argument {1, 1, 2, 1}, it will return {3, 1, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0} because there is three 1s, one 2, zero 3s, zero 4s etc.
	 */
	public ArrayList<Integer> runsK_values(ArrayList<Integer> runs, ArrayList<Integer> pList){
		ArrayList<Integer> runsKvalues = new ArrayList<>();
		int kCount = 0;
		for (int i = 1; i < pList.size(); i++) {
			for(int j = 0; j < runs.size(); j++) {
				if(i == runs.get(j)) {
					kCount++;
				}
			}
			runsKvalues.add(kCount);
			kCount = 0;
		}
		return runsKvalues;
	}
	/**
	 * Adds everything element from the list that contains run ups K values to every element that contains run downs K values
	 * @param runsUpCount(run ups K values)
	 * @param runsDownCount(run downs K values)
	 * @return merged list
	 * EX)argument 1 {3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0} + argument 2 {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0} returns {4, 2, 1, 0, 0, 0, 0, 0, 0, 0 , 0}
	 */
	public ArrayList<Integer> mergeLists(ArrayList<Integer> runsUpCount, ArrayList<Integer> runsDownCount) {
		ArrayList<Integer> merged = new ArrayList<>();
		for (int i = 0; i < runsUpCount.size(); i++) {
			merged.add(runsUpCount.get(i) + runsDownCount.get(i));
		}
		return merged;
	}
	/**
	 * this gets the sum of all the values in merged list
	 * @param mergedList
	 * @return sum
	 */
	public int getKsum(ArrayList<Integer> mergedList) {
		int sum = 0;
		for(int i : mergedList) {
			sum = sum + i;
		}
		return sum;
	}
	/**
	 * Writes the different K values to a text file
	 * @param fileName (Name of file we ant to write)
	 * @param kValues (merged list values)
	 * @param kSum (the sum of values on merged list)
	 */
	public void writeOutputFile(String fileName, ArrayList<Integer> kValues, int kSum) throws FileNotFoundException {//throws file not found to run() method
		try {
			PrintWriter output = new PrintWriter(new File(fileName));
			output.println("runs_total: " + kSum);//first we print runs_total
			int count = 1;
			for(int i = 0; i < kValues.size(); i++) {
				output.println("runs_" + count + ": " + kValues.get(i)); // then we print each runs_1 - runs_11
				count++;
			}
			output.close();
		} catch (IOException e) {
			System.out.println("There was a IOException");
			System.exit(-200);
		}
	}
}
