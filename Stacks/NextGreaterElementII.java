/*
Problem: Next Greater Element II

Description: Given a circular integer array nums, return the next greater number for every element. The next greater element of a number x is the first number greater than x while traversing the array circularly.  If no greater element exists, return -1.

Example 1:
Input  : nums = [1, 2, 1]
Output : [2, -1, 2]

Example 2:
Input  : nums = [1, 2, 3, 4, 3]
Output : [2, 3, 4, -1, 4]

--------------------------------------------------

Approach 1: Brute Force

- Traverse every element using index i.
- First search for a greater element from i+1 to n-1.
- If not found, search from index 0 to i-1.
- If no greater element exists, store -1.

Time Complexity  : O(n^2)
Space Complexity : O(n)

--------------------------------------------------

Approach 2: Optimal Monotonic Stack

- Traverse the array twice from right to left.
- Use modulo (%) to simulate circular traversal.
- Remove all smaller than or equal to current elements from the stack.
- The stack top gives the next greater element.
- Store the answer only during the second traversal (i < n).

Time Complexity  : O(n)
Space Complexity : O(n)

--------------------------------------------------

Edge Cases:
- Empty array.
- Single element.
- All elements are equal.
- No greater element exists.
- Circular next greater element exists.
*/

package Stacks;
import java.util.Stack;

// ----------------------------------- Approach 1: Brute Force -----------------------------------

class NextGreaterElementIIBruteForce {

    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            boolean found = false;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    arr[i] = nums[j];
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        arr[i] = nums[j];
                        found = true;
                        break;
                    }
                }
            }

            if (!found) arr[i] = -1;
            
        }
        return arr;
    }
}

// ----------------------------------- Approach 2: Optimal Monotonic Stack -----------------------------------

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!st.isEmpty() && st.peek() <= nums[idx]) st.pop();

            if (i < n) {
                if (st.isEmpty()) ans[idx] = -1;
                else ans[idx] = st.peek();
            }
            st.push(nums[idx]);
        }
        return ans;
    }
}