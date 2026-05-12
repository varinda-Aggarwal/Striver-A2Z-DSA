/*
 Problem: Swapping Nodes in a Linked List

 Description:
 Given the head of a linked list and an integer k, 
 return the head of the linked list after swapping the values of the kth node from the beginning 
 and the kth node from the end (1-indexed).

 Example:
 Input  : 1 → 2 → 3 → 4 → 5, k = 2
 Output : 1 → 4 → 3 → 2 → 5

 --------------------------------------------------
 APPROACH : OPTIMAL (Slow Fast Pointer)
 --------------------------------------------------
 Step 1: Move fast pointer to kth node from beginning. Save this as first target node.
 Step 2: Move both slow and fast together until fast reaches the last node.
         Now slow is at kth node from end.
 Step 3: Swap values of both target nodes.

 Why this works?
 → Gap between slow and fast is always k nodes.
   When fast reaches end, slow is exactly k steps
   from the end i.e. kth node from end.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Single node → return head (k=1, same node swapped)
 - k = 1 → swap first and last node values
 - k = n → same as k = 1 (symmetric)
 - Even length list → works correctly
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

public class SwappingNodes {

    // --------------------------- OPTIMAL APPROACH -----------------------

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // step 1: move fast to kth node from beginning
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        // save kth node from beginning
        ListNode temp = fast;
        // step 2: move both until fast reaches last node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // step 3: swap values of both target nodes
        int temp1 = temp.val;
        temp.val = slow.val;
        slow.val = temp1;
        return head;
    }
}