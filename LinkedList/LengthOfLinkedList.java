/*
  Problem: Find Length of Linked List
 
  Description:
  Given the head of a linked list, return the
  total number of nodes in the linked list.
 
  --------------------------------------------------
   APPROACH 1 : ITERATIVE
  --------------------------------------------------
   Traverse the linked list node by node and keep
   incrementing count until end of list is reached.
 
   Time Complexity  : O(n) → traverse entire list
   Space Complexity : O(1) → only count variable used
 
   Edge Cases:
   - Empty list        → return 0
   - Single node       → return 1
   
  --------------------------------------------------
   APPROACH 2 : RECURSIVE
  --------------------------------------------------
    Count current node as 1 and recursively count
    the rest of the list. Base case is when head
    is null meaning end of list is reached.
 
    Time Complexity  : O(n) → traverse entire list
    Space Complexity : O(n) → recursive call stack
 
    Edge Cases:
    - Empty list        → return 0
    - Single node       → return 1
 */

package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int value) {
        this.val   = value;
        this.next  = null;
    }
}

public class LengthOfLinkedList {

     // ----------------- ITERATIVE APPROACH -------------------

    public int getLengthIterative(ListNode head) {
        int count = 0;
        // traverse list and count nodes
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // ----------------------- RECURSIVE APPROACH ----------------------------

    public int getLengthRecursive(ListNode head) {
        // base case — end of list
        if (head == null) return 0;
        // count current node and recursively count rest
        return 1 + getLengthRecursive(head.next);
    }
}