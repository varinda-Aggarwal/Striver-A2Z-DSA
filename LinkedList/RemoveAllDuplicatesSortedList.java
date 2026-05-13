/*
Problem: Remove All Duplicates from Sorted Linked List

Description:
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list. Return the linked list sorted as well.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (HashMap)
--------------------------------------------------
 First pass — store frequency of every element in HashMap.
 Second pass — add only those nodes to new list whose
 frequency is exactly 1.

 Time Complexity  : O(2n) → two separate traversals
 Space Complexity : O(n)  → HashMap stores all elements

 Edge Cases:
 - Empty list → return null
 - Single node → return head
 - All duplicates → return null
 - No duplicates → return head unchanged

--------------------------------------------------
 APPROACH 2 : OPTIMAL (New List with Unique Elements)
--------------------------------------------------
 Traverse the list and add only those nodes to new list whose value is different
 from both next node and previously added node. Handle last node separately.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(1) → only constant extra pointers

 Edge Cases:
 - Empty list → return null
 - Single node → return head
 - All duplicates → return null
 - No duplicates → return head unchanged
--------------------------------------------------
*/

package LinkedList;
import java.util.HashMap;

public class RemoveAllDuplicatesSortedList {

    //  ------------------- BRUTE FORCE APPROACH -------------------------

    public ListNode deleteDuplicatesBrute(ListNode head) {
        if (head == null || head.next == null) return head;    // empty or single node
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();  // store frequency of every element
        ListNode temp = head; 

        // pass 1 — count frequency of all elements
        while (temp != null) {
            frequencyMap.put(temp.val, frequencyMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        // pass 2 — add only unique elements to new list
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (frequencyMap.get(curr.val) == 1) {
                ans.next = curr;
                ans = ans.next;
            }
            curr = curr.next;
        }
        ans.next = null;
        return dummy.next;
    }


    public ListNode deleteDuplicatesOptimal(ListNode head) { 
        if (head == null || head.next == null) return head;     // empty or single node
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        ListNode temp = head;
        ListNode prev = new ListNode(-101);  // tracks last added node

        while (temp != null && temp.next != null) {
            // add only if current value is unique from both sides
            if (temp.val != temp.next.val && prev.val != temp.val) {
                ans.next = temp;
                ans = ans.next;
            }
            prev = temp;
            temp = temp.next;
        }

        // check last node
        if (temp != null && prev.val != temp.val) {
            ans.next = temp;
            ans = ans.next;
        }
        ans.next = null;
        return dummy.next;
    }
}