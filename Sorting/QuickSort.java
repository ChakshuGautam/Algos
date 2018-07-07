package Algos.Sorting;
import java.util.Arrays;

/**
 * Created by chaks on 7/5/18.
 */

/**
 * Adapted from
 * http://rosettacode.org/wiki/Sorting_algorithms/Quicksort
 * The current implementation is the in place quick sort.
 *
 * Quick sort lives upto its name and is the fastest sort out there.
 *
 * "On average, mergesort does fewer comparisons than quicksort, so it may be better when complicated comparison
 * routines are used. Mergesort also takes advantage of pre-existing order, so it would be favored for using sort()
 * to merge several sorted arrays. On the other hand, quicksort is often faster for small arrays, and on arrays of a
 * few distinct values, repeated many times." — http://perldoc.perl.org/sort.html
 *
 * A good discussion to look at is here. I am presenting the answer here.
 *
 * https://cs.stackexchange.com/questions/3/why-is-quicksort-better-than-other-sorting-algorithms-in-practice
 */


public class QuickSort {

    static void sort(int array[], int left, int right) {
        if (right > left){
            int i = left, j = right, tmp; //we want j to be right, not right-1 since that leaves out a number during recursion

            int pivot = array[right];

            do {
                while(array[i] < pivot)
                    i++;
                while(array[j] > pivot)
                    //no need to check for 0, the right condition for recursion is the 2 if statements below.
                    j--;

                if(i <= j){            //your code was i<j
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    i++;
                    j--;
                    //we need to +/- both i,j, else it will stick at 0 or be same number
                }
            } while(i <= j);        // Handling the zero case

            // this are the 2 conditions we need to avoid infinite loops
            // check if left < j, if it isn't, it's already sorted. Done

            if(left < j)  sort(array, left, j);
            //check if i is less than right, if it isn't it's already sorted. Done
            // here i is now the 'middle index', the slice for divide and conquer.

            if(i < right) sort(array, i, right);
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        int b[] = {10, 9, 8, 7, 7, 7, 7, 3, 2, 1};
        sort(b, 0, b.length-1);
        System.out.println(Arrays.toString(b));
    }
}



