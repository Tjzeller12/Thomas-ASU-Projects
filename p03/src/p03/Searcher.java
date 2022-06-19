/**
 * A brief description of what the method does.
 */
//*********************************************************************************************
// CLASS: classname (Searcher.java)
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

public class Searcher {

    public static int search(ArrayList<Student> pList, String pKey) {
        return recBinarySearch(pList, pKey, 0, pList.size() - 1);
    }

    // Last Name search (binary) recursion
    private static int recBinarySearch(ArrayList<Student> pList, String pKey,
            int pLo, int pHi) {
        // Base case
        if (pLo > pHi) {
            return -1;
        }
        int mid = (pLo + pHi) / 2;  //
        int result = pList.get(mid).getLastName().compareTo(pKey);
        if (result < 0) {
// If value is more than middle, search mid to hi
            return recBinarySearch(pList, pKey, mid + 1, pHi);
        } else if (result > 0) {
// If value is less than middle, search hi to mid
            return recBinarySearch(pList, pKey, pLo, mid - 1);
        } else {
// When key matches "mid," return mid
            return mid;
        }
    }
}
