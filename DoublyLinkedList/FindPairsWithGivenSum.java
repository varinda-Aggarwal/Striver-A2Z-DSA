/*
Problem: Find Pairs with Given Sum in Doubly Linked List

Description:
Given the head of a sorted doubly linked list of distinct
positive integers and a target, return all unique pairs
whose sum equals target. Each pair [a, b] should have a < b.

--------------------------------------------------
 APPROACH : TWO POINTER
--------------------------------------------------
 Place left pointer at head and right pointer at tail.
 If sum equals target — add pair and move both pointers.
 If sum greater than target — move right pointer back.
 If sum less than target — move left pointer forward.
 Stop when pointers meet or cross each other.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only two pointers used

 Edge Cases:
 - Empty list        → return empty list
 - Single node       → return empty list
 - No valid pairs    → return empty list
--------------------------------------------------
*/

package DoublyLinkedList;
import java.util.ArrayList;
import java.util.List;

public class FindPairsWithGivenSum {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // empty or single node
        if (head == null || head.next == null) return result;
        ListNode left  = head;
        ListNode right = head;

        // move right pointer to tail
        while (right.next != null) {
            right = right.next;
        }

        while (left != right && left.prev != right) {
            int sum = left.val + right.val;
            if (sum == target) {
                // valid pair found
                List<Integer> pair = new ArrayList<>();
                pair.add(left.val);
                pair.add(right.val);
                result.add(pair);
                left  = left.next;
                right = right.prev;

            }
             else if (sum > target) {
                // sum too large — move right back
                right = right.prev;

            } 
            else {
                // sum too small — move left forward
                left = left.next;
            }
        }
        return result;
    }
}