/*
 Problem: Sort Colors (Dutch National Flag Problem)
 
  Description:
  Given an array containing only 0s, 1s, and 2s,
  sort the array in-place without using any built-in sort function.
 
  -----------------------------------------------------
    APPROACH 1 : BRUTE FORCE 
  -----------------------------------------------------
   Use Java's built-in Arrays.sort() to sort the array.
   Simple but does not take advantage of the fact that
   array contains only 3 distinct values.
 
   Time Complexity  : O(n log n) → Arrays.sort() uses dual pivot quicksort
   Space Complexity : O(1)       → in-place sorting
 
   Edge Cases:
   - Array already sorted   → still runs in O(n log n)
   - All elements same      → returns same array
   - Single element         → returns same array
  -----------------------------------------------------

  -----------------------------------------------------
    APPROACH 2 : BETTER (Counting)
  -----------------------------------------------------
   Since array has only 0s, 1s and 2s, count each of them
   in first traversal. Then overwrite the array in second
   traversal using the counts.
 
   Time Complexity  : O(2n) → two separate traversals
   Space Complexity : O(1)  → only 3 counter variables
 
   Edge Cases:
   - Array already sorted   → counts set correctly, overwrites same
   - All elements same      → only one counter is non-zero
   - Single element         → works correctly
  ---------------------------------------------------------
 
  ----------------------------------------------------------
    APPROACH 3 : OPTIMAL (Dutch National Flag)
  -----------------------------------------------------------
   Use three pointers low, mid, high.
   - Everything before low  → 0s
   - low to mid             → 1s
   - Everything after high  → 2s
 
   At each step —
   - nums[mid] == 0 → swap with low, move both low and mid forward
   - nums[mid] == 1 → mid is in correct place, move mid forward
   - nums[mid] == 2 → swap with high, move high backward
 
   Time Complexity  : O(n) → single traversal
   Space Complexity : O(1) → only three pointer variables
 
   Edge Cases:
   - Array already sorted   → pointers adjust without unnecessary swaps
   - All elements same      → only one pointer moves
   - Single element         → loop does not execute
  --------------------------------------------------
 */

package Arrays;
import java.util.Arrays;
public class SortColors{
//     --------------- Brute Force Approach --------------

    public void sortColorsBrute(int[] nums) {
        // directly sort using built-in function
        Arrays.sort(nums);
    }

//    ------------------- Better Approach ---------------

    public void sortColorsBetter(int[] nums) {
        // count occurrences of 0s, 1s and 2s
        int zeroCount = 0;
        int oneCount  = 0;
        int twoCount  = 0;

        for (int num : nums) {
            if(num == 0) 
                zeroCount++;
            else if(num == 1) 
                oneCount++;
            else
                twoCount++;
        }

        // overwrite array using counts
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                nums[i] = 0;
                zeroCount--;
            } 
            else if (oneCount > 0) {
                nums[i] = 1;
                oneCount--;
            } 
            else {
                nums[i] = 2;
                twoCount--;
            }
        }
    }

//      ----------------- Optimal Approach ----------------

    public void sortColorsOptimal(int[] nums) {
        int low  = 0;                // boundary for 0s
        int mid  = 0;                // current element under consideration
        int high = nums.length - 1;  // boundary for 2s

        while (mid <= high) {
            if (nums[mid] == 0) {
                // current element is 0 — belongs to left region
                swap(nums, low, mid);
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                // current element is 1 — already in correct region
                mid++;
            } 
            else {
                // current element is 2 — belongs to right region
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}