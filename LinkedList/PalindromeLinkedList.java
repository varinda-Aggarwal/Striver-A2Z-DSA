/*
Problem: Palindrome Linked List

Description:
Given the head of a singly linked list, return true
if it is a palindrome or false otherwise.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Copy + Reverse)
--------------------------------------------------
 Create a copy of the original list. Reverse the copy
 and compare it with the original list node by node.

 Time Complexity  : O(n) → copy + reverse + compare
 Space Complexity : O(n) → extra list created for copy

 Edge Cases:
 - Empty list        → return true
 - Single node       → return true
 - Even length list  → works correctly

--------------------------------------------------
 APPROACH 2 : OPTIMAL (Slow Fast Pointer)
--------------------------------------------------
 Find the middle of the list using slow fast pointer.
 Reverse the second half in-place and compare with
 first half. No extra space needed.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(1) → only pointers used

 Edge Cases:
 - Empty list        → return true
 - Single node       → return true
 - Even length list  → works correctly
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

public class PalindromeLinkedList{

    // ---------------------------- BRUTE FORCE APPROACH -----------------
    public ListNode reverselist(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode agla = null;
        while (curr!=null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public ListNode copyList(ListNode head) {
        // dummy node to simplify insertion
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (head != null) {
            temp.next = new ListNode(head.val);
            temp = temp.next;
            head = head.next;
        }
        return dummy.next;
    }

    public boolean isPalindromeBrute(ListNode head) {
        // create copy and reverse it
        ListNode copy = copyList(head);
        ListNode reverse = reverselist(copy);
        ListNode temp = head;

        // compare original with reversed copy
        while (reverse != null && temp != null) {
            if (reverse.val != temp.val) return false;
            reverse = reverse.next;
            temp = temp.next;
        }
        return true;
    }


    // --------------------------- OPTIMAL APPROACH -----------------------
    
    public ListNode reverseList(ListNode head) {
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

    public boolean isPalindromeOptimal(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // find middle using slow fast pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // compare both halves
        while (secondHalf != null && firstHalf != null) {
            if (secondHalf.val != firstHalf.val) return false;
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }
}