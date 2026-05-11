/*
 Problem: Delete the Middle Node of a Linked List

 Description:
 Given the head of a singly linked list, delete the middle node
 and return the head of the modified list.

 --------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Count + Traverse)
 --------------------------------------------------
 First count total nodes to find middle index. Then traverse again up to (mid-1)th node and skip the middle node.

 Time Complexity  : O(n) + O(n) → two traversals
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list → return null
 - Single node → return null (no middle left)
 - Two node list → delete second node
 - Even length list → delete upper middle (floor(n/2))

 --------------------------------------------------
 APPROACH 2 : OPTIMAL (Slow Fast Pointer)
 --------------------------------------------------
 Start fast pointer 2 steps ahead of slow. When fast reaches end, slow is just BEFORE the middle.
 This lets us directly skip the middle node.

 Why fast starts at head.next.next?
 → So that slow stops at the node BEFORE middle,
   not at middle itself (we need prev to delete).

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list → return null
 - Single node → return null (no middle left)
 - Two node list → delete second node
 - Even length list → delete upper middle (floor(n/2))
*/

package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val  = val;
        this.next = null;
    }
}

public class DeleteMiddleNode {

    // --------------------------- BRUTE FORCE APPROACH -------------------

    public ListNode deleteMiddleBrute(ListNode head) {
        if (head == null || head.next == null) return null;   // edge case: 0 or 1 node → no middle remaining
        int count = 0;   // step 1: count total nodes
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;  // step 2: find middle index

        // step 3: traverse to node just before middle
        ListNode slow = head;
        for (int i = 1; i < mid; i++) {
            slow = slow.next;
        }
        slow.next = slow.next.next;     // skip the middle node
        return head;
    }


    // --------------------------- OPTIMAL APPROACH -----------------------

    public ListNode deleteMiddleOptimal(ListNode head) {
        if (head == null || head.next == null) return null;  // edge case: 0 or 1 node → no middle remaining
        ListNode slow = head;
        ListNode fast = head.next.next;      // fast starts 2 steps ahead

        // when fast reaches end, slow is just before middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;   // skip the middle node
        return head;
    }
}