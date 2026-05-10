/*
  Problem: Search a Key in Linked List
 
  Description:
  Given the head of a linked list and a key, return true if the key exists in the linked list, false otherwise.
 
  --------------------------------------------------
   APPROACH 1 : ITERATIVE
  --------------------------------------------------
   Traverse the linked list node by node and check if current node data matches the key.
 
   Time Complexity  : O(n) → traverse entire list
   Space Complexity : O(1) → no extra space used
 
   Edge Cases:
   - Empty list          → return false
   - Key at head         → return true immediately
   - Key not in list     → return false after full traversal

  --------------------------------------------------
   APPROACH 2 : RECURSIVE
  --------------------------------------------------
   Check current node data, if not matched recursively check the rest of the list. 
   Base case is when head is null meaning key was not found.
 
   Time Complexity  : O(n) → traverse entire list
   Space Complexity : O(n) → recursive call stack
 
   Edge Cases:
   - Empty list          → return false
   - Key at head         → return true immediately
   - Key not in list     → return false after full traversal
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

public class SearchKey {

    public boolean SearchKeyIterative(Node head, int key) {
        // traverse list until end
        while (head != null) {
            // key found
            if (head.data == key) return true;
            // move to next node
            head = head.next;
        }
        // key not found
        return false;
    }

    public boolean SearchKeyRecursive(Node head, int key) {
        // base case — end of list, key not found
        if (head == null) return false;
        // key found at current node
        if (head.data == key) return true;
        // recursively search in remaining list
        return SearchKeyRecursive(head.next, key);
    }
}