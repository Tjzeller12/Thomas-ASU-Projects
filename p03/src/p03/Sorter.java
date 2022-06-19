/**
 * A brief description of what the method does.
 */
//*********************************************************************************************
// CLASS: classname (Sorter.java)
//
// COURSE AND PROJECT INFO:
// CSE205 Object Oriented Programming and Data Structures, summer 2021
// Project Number: 02
//
// AUTHOR: Thomas Zeller,   tjzeller,   tjzeller@asu.edu;
//		   Michael Zeller,  mrzeller,   mrzeller@asu.edu;
//		   Daniel King,     deking4,    deking4@asu.edu;
//		   Mary Crowe,      mecrowe,    mecrowe@asu.edu;
//*********************************************************************************************
package p03;

import java.util.ArrayList;

public class Sorter {

// Create two internal lists to Array for comparison
    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        Student part = pList.get(pFromIdx);
        int leftIndex = pFromIdx - 1;
        int rightIndex = pToIdx + 1;
        while (leftIndex < rightIndex) {
            leftIndex++;
            while (pList.get(leftIndex).compareTo(part) == -1) {
                leftIndex++;
            }
            rightIndex--;
            while (pList.get(rightIndex).compareTo(part) == 1) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(pList, leftIndex, rightIndex);
            }
        }
        return rightIndex;
    }
// Implementation of the quickSort method from notes

    private static void qSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        if (pFromIdx < pToIdx) {
            int partitionIndex = partition(pList, pFromIdx, pToIdx);
            qSort(pList, pFromIdx, partitionIndex);
            qSort(pList, partitionIndex + 1, pToIdx);
        }
    }
// Entry point for the Sorter

    public static void sort(ArrayList<Student> pList) {
        qSort(pList, 0, pList.size() - 1);
    }

// Method to swap two elements within the list
    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2) {
        Student temp = pList.get(pIdx1);
        pList.set(pIdx1, pList.get(pIdx2));
        pList.set(pIdx2, temp);
    }
}
