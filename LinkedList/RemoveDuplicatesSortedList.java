/*
 Problem: Remove Duplicates from Sorted List

 Description:
 Given the head of a sorted linked list, delete all duplicates such
 that each element appears only once. Return the sorted linked list.

 Example:
 Input  : 1 → 1 → 2 → 3 → 3
 Output : 1 → 2 → 3

 --------------------------------------------------
 APPROACH : OPTIMAL (Two Pointer)
 --------------------------------------------------
 Use two pointers temp and value. temp points to last confirmed unique node.
 value scans ahead to find next unique node.
 If value is different from temp, link it to temp and move temp forward.
 At the end, set temp.next = null to cut off any remaining duplicates.

 Time Complexity : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list → return null
 - Single node → return head (no duplicates)
 - All duplicates → return single node
 - No duplicates → return original list
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

public class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;    // edge case: empty list
        ListNode temp  = head;            // points to last unique node
        ListNode value = head.next;       // scans ahead for next unique node

        while (value != null) {
            // found a unique node → link it to temp
            if (temp.val != value.val) {
                temp.next = value;
                temp = temp.next;
            }
            value = value.next;
        }
        temp.next = null;   // cut off remaining duplicates at the end
        return head;
    }
}