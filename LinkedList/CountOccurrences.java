/*
Problem: Count Occurrences of a Key in Linked List

Description:
Given the head of a linked list and a key, return the number of times the key appears in the linked list.

--------------------------------------------------
 APPROACH : SINGLE TRAVERSAL
--------------------------------------------------
 Traverse the entire list and increment count whenever current node data matches the key.

 Time Complexity  : O(n) → traverse entire list
 Space Complexity : O(1) → only count variable used

 Edge Cases:
 - Empty list        → return 0
 - Key not in list   → return 0
 - All nodes match   → return length of list.
*/

package LinkedList;

public class CountOccurrences {
    public static int count(Node head, int key) {
        int count = 0;
        // traverse list and count matching nodes
        while (head != null) {
            if (head.data == key) count++;
            head = head.next;
        }
        return count;
    }
}