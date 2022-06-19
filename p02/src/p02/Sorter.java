package p02;

//********************************************************************************************************
//CLASS: Sorter (Sorter.java)
//
//DESCRIPTION: This class sorts an arrayList of Students in ascending or descending order
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, summer 2021
//Project Number: 02
//
//AUTHOR: Thomas Zeller, tjzeller, tjzeller@asu.edu;
//		  Michael Zeller, mrzeller, mrzeller@asu.edu;
//		  Daniel King, deking4, deking4@asu.edu;
//		  Mary Crowe,  mecrowe,	mecrowe@asu.edu;
			
//********************************************************************************************************
import java.util.ArrayList;
public class Sorter {
	public final int SORT_ASCENDING = 0;
	public final int DESCENDING = 1;
	/**
	 * Sorts a list of students using the keepMoving and swap helper methods
	 * @param pList
	 * @param pOrder
	 */
	public void insertionSort(ArrayList<Student> pList, int pOrder) {
		 for (int i = 1; i < pList.size(); ++i) {
	            for (int j = i; keepMoving(pList, j, pOrder); --j) {
	                swap(pList, j, j - 1);
	            }
		 }
	}
	/**
	 * Checks whether program should keep moving through the list or whether it should swap the elements
	 * @param pList
	 * @param pIndex
	 * @param pOrder
	 * @return 
	 */
	private boolean keepMoving(ArrayList<Student> pList, int pIndex, int pOrder) {
        if (pIndex < 1) return false;
        Student after = pList.get(pIndex);
        Student before = pList.get(pIndex - 1);
        return (pOrder == SORT_ASCENDING) 
            ? after.compareTo(before) < 0 
            : after.compareTo(before) > 0;

	}
	/**
	 * Swaps two elements in the list
	 * @param pList
	 * @param pIndex1
	 * @param pIndex2
	 */
	private void swap(ArrayList<Student> pList, int pIndex1, int pIndex2) {
        Student temp = pList.get(pIndex1);
        pList.set(pIndex1, pList.get(pIndex2));
        pList.set(pIndex2, temp);
	}
}
