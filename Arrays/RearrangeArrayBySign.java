/*
Problem: Rearrange Array Elements by Sign

Description:
Given an array containing equal number of positive and negative integers,
rearrange the array such that:
- Positive and negative numbers are placed alternately
- Positive number starts first
- Relative order should be maintained whenever possible

Example:
Input  : [3,1,-2,-5,2,-4]
Output : [3,-2,1,-5,2,-4]

--------------------------------------------------
Approach 1: Brute Force (Shifting Technique)
--------------------------------------------------
- Traverse the array index by index
- If current index expects:
    • positive at even index
    • negative at odd index
  but the current element is incorrect,
  then search ahead for the required element
- After finding it, shift elements one step right
- Place required element at correct position

Time Complexity  : O(n²)
Space Complexity : O(1)

Why O(n²)?
- For every incorrect element, shifting may take O(n)

Edge Cases:
- Array size = 2
- Already arranged array
- All positives and negatives equally distributed

--------------------------------------------------
Approach 2: Better Approach (Using Separate Arrays)
--------------------------------------------------
- Store all positive elements in one array
- Store all negative elements in another array
- Rebuild original array alternately using both arrays

Time Complexity  : O(n)
Space Complexity : O(n)

Why Better?
- Avoids costly shifting operation
- Easier to understand and implement

--------------------------------------------------
Approach 3: Optimal Approach (Direct Placement)
--------------------------------------------------
- Create a result array of same size
- Maintain:
    • pos index starting from 0 (even indices)
    • neg index starting from 1 (odd indices)
- Traverse original array:
    • Place positive numbers at even positions
    • Place negative numbers at odd positions

Time Complexity  : O(n)
Space Complexity : O(n)

Why Optimal?
- Single traversal
- No extra positive/negative arrays required
- Cleaner and more efficient than Approach 2
*/

package Arrays;

public class RearrangeArrayBySign{

    // ---------------------- Approach 1: Brute Force (Shifting Technique) -----------------

    public int[] rearrangeBruteForce(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int currentIndex = i;
            // Even index should contain positive number
            if(i % 2 == 0 && nums[i] < 0) {
                // Find next positive number
                while(currentIndex < nums.length && nums[currentIndex] < 0) {
                    currentIndex++;
                }
            }
            // Odd index should contain negative number
            else if(i % 2 != 0 && nums[i] > 0) {
                // Find next negative number
                while(currentIndex < nums.length && nums[currentIndex] > 0) {
                    currentIndex++;
                }
            }
            // Shift elements to place required element at correct position
            while(currentIndex != i) {
                swap(nums, currentIndex, currentIndex - 1);
                currentIndex--;
            }
        }
        return nums;
    }

    // Utility function to swap two elements
    public static void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    // ------------------- Approach 2: Better Approach (Using Separate Arrays) -----------------

    public int[] rearrangeBetter(int[] nums) {
        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length / 2];
        int positiveIndex = 0;
        int negativeIndex = 0;
        // Separate positive and negative elements
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                positive[positiveIndex] = nums[i];
                positiveIndex++;
            }
            else {
                negative[negativeIndex] = nums[i];
                negativeIndex++;
            }
        }
        positiveIndex = 0;
        negativeIndex = 0;
        // Rebuild original array alternately
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                nums[i] = positive[positiveIndex];
                positiveIndex++;
            }
            else {
                nums[i] = negative[negativeIndex];
                negativeIndex++;
            }
        }
        return nums;
    }

    // -------------------- Approach 3: Optimal Approach (Direct Placement) ------------------

    public int[] rearrangeOptimal(int[] nums) {
        int[] result = new int[nums.length];
        // Even index for positive numbers
        int positiveIndex = 0;
        // Odd index for negative numbers
        int negativeIndex = 1;
        // Traverse array and place elements directly
        for(int i = 0; i < nums.length; i++) {
            // Place positive number at even index
            if(nums[i] > 0) {
                result[positiveIndex] = nums[i];
                positiveIndex += 2;
            }
            // Place negative number at odd index
            else {
                result[negativeIndex] = nums[i];
                negativeIndex += 2;
            }
        }
        return result;
    }
}