/*
Problem: Intersection of Two Linked Lists

Description:
Given the heads of two singly linked lists, return the
node at which the two lists intersect. If the two linked
lists have no intersection, return null.

--------------------------------------------------
 APPROACH : LENGTH DIFFERENCE
--------------------------------------------------
 Find length of both lists. Advance the pointer of
 longer list by the difference in lengths. Then move
 both pointers together until they meet — that is
 the intersection node.

 Time Complexity  : O(n + m) → traverse both lists
 Space Complexity : O(1)     → only pointers used

 Edge Cases:
 - Either list empty    → return null
 - No intersection      → return null
 - Intersection at head → return head
--------------------------------------------------
*/

package LinkedList;

public class IntersectionOfLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // empty list
        if (headA == null || headB == null) return null;

        int sizeA = 0;
        int sizeB = 0;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // find length of list A
        while (temp1 != null) {
            sizeA++;
            temp1 = temp1.next;
        }

        // find length of list B
        while (temp2 != null) {
            sizeB++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        // advance longer list pointer by difference
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                temp1 = temp1.next;
            }
        } 
        else {
            for (int i = 0; i < sizeB - sizeA; i++) {
                temp2 = temp2.next;
            }
        }

        // move both pointers until they meet
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        // no intersection
        return null;
    }
}