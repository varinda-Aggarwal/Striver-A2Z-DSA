/*
  Problem: Find Kth Node from End of Linked List
 
  Description:
  Given the head of a linked list and a number k,
  return the data of the kth node from the end.
  If k is greater than the length of list, return -1.
 
  --------------------------------------------------
   APPROACH 1 : BRUTE FORCE (Two Traversals)
  --------------------------------------------------
   First find the length of the list. Then calculate
   the index from the start and traverse to that node.
 
   Time Complexity  : O(2n) → two separate traversals
   Space Complexity : O(1)  → no extra space used
 
   Edge Cases:
   - Empty list       → return -1
   - k out of range   → return -1
   - k equals length  → return head data
  --------------------------------------------------
 
  --------------------------------------------------
   APPROACH 2 : OPTIMAL (Two Pointers)
  --------------------------------------------------
   Move fast pointer k steps ahead. Then move both
   fast and slow together until fast reaches end.
   At this point slow is at kth node from end.
   Single traversal — no need to find length first.
 
   Time Complexity  : O(n) → single traversal
   Space Complexity : O(1) → only two pointers used
 
   Edge Cases:
   - Empty list       → return -1
   - k out of range   → fast becomes null before k steps
   - k equals length  → slow stays at head
  --------------------------------------------------
 */

package LinkedList;
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// -------------------------BRUTE FORCE APPROACH ------------------

public class NthNodeFromLast {
    int getKthFromLastBrute(Node head, int k) {
        int length = 0;      // find length of list
        Node temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // k is out of range
        if (length < k) return -1;

        // calculate index from start
        int index  = length- k+1;
        int count  = 1;
        Node curr  = head;

        // traverse to that index
        while (count < index && curr != null) {
            curr = curr.next;
            count++;
        }
        return curr.data;
    }

//  --------------------------OPTIMAL APPROACH --------------------

    int getKthFromLastOptimal(Node head, int k) {
        Node fast = head;
        Node slow = head;
        // move fast pointer k steps ahead
        for (int i = 1; i <= k; i++) {
            if (fast == null) return -1;  // k out of range
            fast = fast.next;
        }
        // move both pointers until fast reaches end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // slow is now at kth node from end
        return slow.data;
    }
}