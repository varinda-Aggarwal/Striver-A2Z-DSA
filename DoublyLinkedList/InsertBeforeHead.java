/*
Problem: Insert Before Head in Doubly Linked List

Description:
Given the head of a doubly linked list and a value,
insert a new node with that value before the head
and return the new head.

--------------------------------------------------
 APPROACH : NEW NODE AT FRONT
--------------------------------------------------
 Create a new node. Point its next to current head
 and update head's prev to new node.
 Return new node as new head.

 Time Complexity  : O(1) → direct insertion at front
 Space Complexity : O(1) → only one new node created

 Edge Cases:
 - Empty list  → new node becomes head
 - Single node → new node inserted before existing node
--------------------------------------------------
*/

package DoublyLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val  = val;
        this.next = null;
        this.prev = null;
    }
}
public class InsertBeforeHead {
    public ListNode insertBeforeHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);    // create new node with given value
        if (head == null) return newNode;         // if list is empty new node becomes head
        newNode.next = head;               // point new node to current head
        head.prev = newNode;               // update head's prev to new node
        return newNode;                    // new node is now the head
    }
}