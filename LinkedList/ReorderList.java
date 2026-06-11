/*
Problem: Reorder Linked List

Description:
Given the head of a singly linked list reorder it to:
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
You may not modify the values, only nodes may be changed.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Stack)
--------------------------------------------------
 Find mid and push second half into stack. Then alternate between first half and stack top while relinking nodes in-place.

 Time Complexity : O(n) → traversal + stack operations
 Space Complexity : O(n) → stack stores second half

--------------------------------------------------
 APPROACH 2 : OPTIMAL (Mid + Reverse + Merge)
--------------------------------------------------
 Step 1 — Find middle of list using slow fast pointer.
 Step 2 — Reverse second half in-place.
 Step 3 — Merge both halves alternately by relinking.

 Time Complexity  : O(n) → three single traversals
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list → return
 - Single node → return
 - Two nodes → return as is
--------------------------------------------------
*/

package LinkedList;
import java.util.Stack;
public class ReorderList {

    //  ------------------------- BRUTE FORCE APPROACH -------------------
    
    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderListBrute(ListNode head) {
        ListNode midNode = mid(head);       // find mid
        ListNode list2 = midNode.next;
        midNode.next = null;

        // push second half into stack
        Stack<ListNode> st = new Stack<>();
        while (list2 != null) {
            st.push(list2);
            list2 = list2.next;
        }

        ListNode list1 = head;

        // alternate between list1 and stack
        while (!st.isEmpty()) {
            ListNode top = st.pop();
            top.next = list1.next;
            list1.next = top;
            list1 = top.next;
        }

        // last node ka next null karo
        if (list1 != null) list1.next = null;
    }


    // -------------------------- OPTIMAL APPROACH -----------------------
  
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode agla = null;
        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public void reorderListOptimal(ListNode head) {
        // step 1 — find middle
        ListNode midNode = mid(head);
        // step 2 — reverse second half
        ListNode list2 = reverse(midNode.next);
        midNode.next = null;
        ListNode list1 = head;

        // step 3 — merge both halves alternately
        while (list2 != null) {
            ListNode next  = list2.next;

            // relink nodes
            list2.next = list1.next;
            list1.next = list2;

            // move pointers forward
            list1 = list2.next;
            list2 = next;
        }
    }
}