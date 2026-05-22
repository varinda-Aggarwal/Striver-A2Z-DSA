/*
 Problem: Swap Nodes in Pairs

 Description:
 Given a linked list, swap every two adjacent nodes and return its head.
 You must solve the problem without modifying the values in the list's nodes
 (i.e., only nodes themselves may be changed).

 Example:
 Input  : 1 → 2 → 3 → 4
 Output : 2 → 1 → 4 → 3

 --------------------------------------------------
 APPROACH : ITERATIVE (Pointer Manipulation)
 --------------------------------------------------
 Track curr, prev and agla pointers. For each pair, reverse the links between curr and agla.
 Connect previous pair's last node to current pair's new head. Move pointers forward by 2 for next pair.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list        → return null
 - Single node       → return head (no swap needed)
 - Odd length list   → last node stays in place
 - Even length list  → all pairs swapped
*/

package LinkedList;

public class SwapNodesInPairs {

    // --------------------------- ITERATIVE APPROACH ---------------------

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;   // edge case: 0 or 1 node → nothing to swap
        ListNode newHead = head.next; // new head after first swap
        ListNode curr = head;
        ListNode prev = null;
        ListNode agla = head.next;
        while (curr != null && curr.next != null) {
            // reverse links between curr and agla
            curr.next = agla.next;
            agla.next = curr;
            // connect previous pair's tail to current pair's new head
            if (prev != null) {
                prev.next = agla;
            }
            // move pointers forward for next pair
            prev = curr;
            curr = curr.next;
            if (curr != null) agla = curr.next;
        }
        return newHead;
    }
}