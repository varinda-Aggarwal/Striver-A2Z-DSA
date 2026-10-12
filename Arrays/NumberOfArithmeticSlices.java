/*
Problem: Number of Arithmetic Slices

Description: An integer array is given. Return the number of arithmetic subarrays of length at least 3. A subarray is arithmetic if the difference between every two consecutive elements is the same.

Example 1:
Input  : nums = [1, 2, 3, 4]
Output : 3

Explanation:
The arithmetic slices are:
[1, 2, 3]
[2, 3, 4]
[1, 2, 3, 4]

Example 2:
Input  : nums = [1]
Output : 0

--------------------------------------------------

Approach 1: Brute Force

- Generate all possible subarrays.
- Consider only subarrays of length at least 3.
- Check whether all consecutive differences are equal.
- If valid, increment count.

Time Complexity  : O(n^3)
Space Complexity : O(1)

--------------------------------------------------

Approach 2: Better Approach

- Fix the starting index i.
- Store the difference between the first two elements.
- Extend the subarray by checking consecutive differences.
- If the difference changes, break the loop.
- Otherwise, count every valid subarray of length at least 3.

Time Complexity  : O(n^2)
Space Complexity : O(1)

--------------------------------------------------

Approach 3: Optimal Approach

- Traverse the array starting from index 2.
- Compare the current difference with the previous difference.
- If both differences are equal, increment count and add it to ans.
- Otherwise, reset count to 0.

Time Complexity  : O(n)
Space Complexity : O(1)

--------------------------------------------------

Edge Cases:
- Array length less than 3.
- All elements have the same difference.
- No arithmetic subarray exists.
*/

package Arrays;

// ----------------------------------- Approach 1: Brute Force -----------------------------------

class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlicesBrute(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int size = j - i + 1;
                if (size >= 3) {
                    int k = i + 1;
                    int val = nums[k] - nums[k - 1];
                    boolean valid = true;
                    while (k <= j) {
                        if (nums[k] - nums[k - 1] != val) {
                            valid = false;
                            break;
                        }
                        k++;
                    }
                    if (valid) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


// ----------------------------------- Approach 2: Better -----------------------------------

    public int numberOfArithmeticSlicesBetter(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int val = 0;
            if (j < nums.length) {
                val = nums[j] - nums[j - 1];
            }
            while (j < nums.length) {
                int size = j - i + 1;
                if (size >= 3 && nums[j] - nums[j - 1] == val) {
                    count++;
                }
                else if (size >= 3) {
                    break;
                }
                j++;
            }
        }
        return count;
    }


// ----------------------------------- Approach 3: Optimal -----------------------------------

    public int numberOfArithmeticSlicesOptimal(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                count++;
                ans += count;
            } 
            else count = 0;
        }
        return ans;
    }
}