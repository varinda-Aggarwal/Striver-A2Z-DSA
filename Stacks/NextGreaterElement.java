/*
Problem: Next Greater Element I

Description: Given two distinct integer arrays nums1 and nums2, where nums1 is a subset of nums2, find the next greater element for every element in nums1.
The next greater element of x is the first element greater than x to its right in nums2. If no such element exists, return -1.

Example 1:
Input  : nums1 = [4, 1, 2], nums2 = [1, 3, 4, 2]
Output : [-1, 3, -1]

Example 2:
Input  : nums1 = [2, 4], nums2 = [1, 2, 3, 4]
Output : [3, -1]

--------------------------------------------------

Approach 1: Brute Force with ArrayList and Stack
- Store nums1 elements in an ArrayList.
- Traverse nums2 from right to left.
- For elements present in nums1, use a stack to find the next greater element.
- Use contains() and indexOf() to locate elements in nums1.

Time Complexity  : O(n * m) in the worst case
Space Complexity : O(n + m)

--------------------------------------------------

Approach 2: Optimal HashMap + Monotonic Stack
- Traverse nums2 from right to left.
- Pop stack elements smaller than the current element.
- The stack top is the next greater element, if one exists.
- Store each result in a HashMap.
- Build the answer for nums1 using the HashMap.

Time Complexity  : O(n + m) average
Space Complexity : O(m)

--------------------------------------------------

Edge Cases:
- No greater element exists.
- The next greater element is the immediate next element.
- nums1 contains one element.
*/

package Stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

// ----------------------------------- Approach 1: ArrayList + Stack -----------------------------------

class NextGreaterElement {
    public int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            arr.add(nums1[i]);
        }

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums1.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (arr.contains(nums2[i])) {
                int idx = arr.indexOf(nums2[i]);
                while (!st.isEmpty() && st.peek() < nums2[i]) st.pop();
                if (st.isEmpty()) ans[idx] = -1;
                else ans[idx] = st.peek();
            }
            st.push(nums2[i]);
        }
        return ans;
    }

// ----------------------------------- Approach 2: Optimal HashMap + Monotonic Stack -----------------------------------

    public int[] nextGreaterElementOptimal(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < nums2[i]) st.pop();
            if (st.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}