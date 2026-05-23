/*
  Problem: Find Nth Node in Linked List
 
  Description:
  Given the head of a linked list and a position index,
  return the data of the node at that position (1-indexed).
  If position is out of range, return -1.
 
  --------------------------------------------------
   APPROACH : TRAVERSE TO NTH NODE
  --------------------------------------------------
   Traverse the linked list until the nth node is
   reached and return its data. If list ends before
   reaching nth position return -1.
 
   Time Complexity  : O(n) → traverse to nth node
   Space Complexity : O(1) → no extra space used
 
   Edge Cases:
   - Empty list           → return -1
   - Index out of range   → return -1
   - Index is 1           → return head data
  --------------------------------------------------
 */

package LinkedList;


public class GetNthNode {
    public int GetNth(Node head, int index) {
        int count = 1;
        Node temp = head;
        // traverse to nth node
        while (count < index && temp != null) {
            temp = temp.next;
            count++;
        }
        // index out of range
        if (temp == null) return -1;
        return temp.data;
    }
}