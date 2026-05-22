/*
Problem: Reverse Linked List

Description:
Given the head of a singly linked list, reverse the list
and return the reversed list.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Extra Space)
--------------------------------------------------
 Create a new linked list by traversing the original list and inserting each node at the front of new list.
 Original list is not modified.

 Time Complexity  : O(n) → traverse entire list
 Space Complexity : O(n) → new nodes created for each element

 Edge Cases:
 - Empty list        → return null
 - Single node       → return head

--------------------------------------------------
 APPROACH 2 : BETTER (Iterative In-Place)
--------------------------------------------------
 Reverse the links between nodes in-place using three pointers — prev, curr, and next. No extra space needed.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only three pointers used

 Edge Cases:
 - Empty list        → return null
 - Single node       → return head

--------------------------------------------------
 APPROACH 3 : RECURSIVE
--------------------------------------------------
 Save next node before breaking the link. Point current node to result, update result, 
 and recursively process the saved next node.

 Time Complexity  : O(n) → traverse entire list
 Space Complexity : O(n) → recursive call stack

 Edge Cases:
 - Empty list        → return null
 - Single node       → return head
--------------------------------------------------
*/

package LinkedList;


public class ReverseLinkedList {

    // ----------------------- BRUTE FORCE APPROACH -----------------

    public ListNode reverseListBrute(ListNode head) {
        ListNode result = null;
        ListNode temp   = head;

        // insert each node at front of new list
        while (temp != null) {
            ListNode newNode = new ListNode(temp.val);
            newNode.next = result;
            result = newNode;
            temp = temp.next;
        }
        return result;
    }

// --------------------------- BETTER APPROACH --------------------------

    public ListNode reverseListBetter(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;    // save next node
            curr.next = prev;    // reverse link
             // move pointers forward
            prev = curr;
            curr = next;
        }
        return prev;
    }

// ---------------------------- OPTIMAL APPROACH --------------------------

    ListNode result = null;
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) return result;     // base case — end of list
        ListNode nextNode = head.next;       // save next node before breaking link
        head.next = result;                  // point current node to result
        result    = head;                    // update result
        reverseListRecursive(nextNode);               // recursively process saved next node
        return result;
    }
}