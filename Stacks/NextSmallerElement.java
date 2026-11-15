
/*
Problem: Next Smaller Element
Description: Given an array of integers, find the next smaller element on the right side of each element. If no smaller element exists, return -1.

Example:
Input: arr = [4, 8, 5, 2, 25]
Output: [2, 5, 2, -1, -1]

--------------------------------------------------
Approach: Optimal (Using Monotonic Stack)

Explanation:
1. Traverse the array from right to left.
2. Remove elements from the stack that are greater than or equal to the current element.
3. If the stack is empty, no smaller element exists.
4. Otherwise, the stack top is the next smaller element.
5. Push the current element into the stack.
6. Reverse the answer because elements were processed from right to left.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Stacks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=arr.length-1; i >= 0; i--) {

            // Remove elements greater than or equal to current
            while (!st.isEmpty() && st.peek() >= arr[i]) st.pop();

            // Find next smaller element
            if (st.isEmpty()) ans.add(-1);
            else ans.add(st.peek());
            st.push(arr[i]);           // Push current element
        }
        Collections.reverse(ans);     // Restore original array order
        return ans;
    }
}
