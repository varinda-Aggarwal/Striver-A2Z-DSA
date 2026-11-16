
/*
Problem: Previous Smaller Element (PSE)

Description: Given an array of integers, find the previous smaller element for every element in the array. The previous smaller element is the nearest element on the left side that is smaller than the current element. If no smaller element exists, return -1.

Example:
Input: arr = [4, 5, 2, 10, 8]
Output: [-1, 4, -1, 2, 2]

--------------------------------------------------
Approach: Optimal (Using Monotonic Stack)

Explanation:
1. Traverse the array from left to right.
2. Use a stack to maintain potential previous smaller elements.
3. Remove elements from the stack that are greater than or equal to the current element.
4. If the stack is empty, add -1 to the answer.
5. Otherwise, the top of the stack is the previous smaller element.
6. Push the current element into the stack.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Stacks;
import java.util.ArrayList;
import java.util.Stack;

public class PreviousSmallerElement {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // Traverse from left to right
        for (int i = 0; i < arr.length; i++) {
            // Remove elements greater than or equal to current
            while (!st.isEmpty() && st.peek() >= arr[i]) st.pop();

            if (st.isEmpty()) ans.add(-1);    // Find previous smaller element
            else ans.add(st.peek());

            st.push(arr[i]);                 // Push current element
        }
        return ans;
    }
}
