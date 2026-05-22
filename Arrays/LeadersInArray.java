/*
Problem: Leaders in an Array

Description:
An element is a leader if it is greater than all elements to its right side. 
The rightmost element is always a leader. Return all leaders in the array.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Nested Loop)
--------------------------------------------------
 For every element check if any element to its right is greater. 
 If no greater element found on right, it is a leader.

 Time Complexity : O(n²) → nested loop for every element
 Space Complexity : O(1)  → no extra space used

 Edge Cases:
 - Single element → that element is leader
 - Sorted descending → all elements are leaders
 - Sorted ascending → only last element is leader
--------------------------------------------------

--------------------------------------------------
 APPROACH 2 : OPTIMAL (Right to Left Traversal)
--------------------------------------------------
 Traverse from right to left tracking maximum element seen so far. If current element is greater than max,
 it is a leader. Reverse result at end to maintain order.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(1) → only max variable used

 Edge Cases:
 - Single element → that element is leader
 - Sorted descending → all elements are leaders
 - Sorted ascending → only last element is leader
--------------------------------------------------
*/

package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {

//       ----------------------- BRUTE APPROACH -----------------------

    public List<Integer> leadersBrute(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        // check every element if it is a leader
        for (int i = 0; i < nums.length; i++) {
            boolean isLeader = true;
            // check if any element to right is greater
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) ans.add(nums[i]);
        }
        return ans;
    }

    //       ----------------------- OPTIMAL APPROACH -----------------------

    public List<Integer> leadersOptimal(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[nums.length - 1]);        // rightmost element is always a leader

        // traverse from second last to first
        for (int i = nums.length - 2; i >= 0; i--) {
            int currentMax = ans.get(ans.size() - 1);    // current max is last added leader
            // if current element is greater than max — it is a leader
            if (nums[i] > currentMax) {
                ans.add(nums[i]);
            }
        }
        Collections.reverse(ans);     // reverse to maintain original order
        return ans;
    }
}