/*
Problem: Next Greater Node in Linked List

Description: Given the head of a linked list, return an array where answer[i] is the value of the next greater node of the ith node. 
If no greater node exists, set answer[i] = 0.

--------------------------------------------------
 APPROACH : REVERSE + STACK (Next Greater Element)
--------------------------------------------------
 Step 1 — Reverse the linked list so we can process from right to left.
 Step 2 — Use a monotonic stack to find next greater element for each node.
           First element of reversed list has no next greater — add 0 and push to stack.
           For each element pop stack until top is greater or stack is empty.
 Step 3 — Result list is built right to left so reverse it while converting to array.

 Time Complexity  : O(n) → single traversal
 Space Complexity : O(n) → stack and result list

 Edge Cases:
 - Single node → return [0]
 - Decreasing list → all zeros
 - Increasing list → last element is 0
--------------------------------------------------
*/

package LinkedList;
import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeLinkedList {
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode agla = null;
        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        // step 1 — reverse list to process right to left
        ListNode rev = reverse(head);

        // first element of reversed list has no next greater
        res.add(0);
        st.push(rev.val);
        rev = rev.next;

        // step 2 — process each node using monotonic stack
        while (rev != null) {
            if (!st.isEmpty() && st.peek() > rev.val) {
                // stack top is next greater
                res.add(st.peek());
                st.push(rev.val);
            } 
            else {
                // pop until greater element found or stack empty
                while (!st.isEmpty()) {
                    if (st.peek() > rev.val) {
                        res.add(st.peek());
                        st.push(rev.val);
                        break;
                    } 
                    else {
                        st.pop();
                    }
                }
                // no greater element found
                if (st.isEmpty()) {
                    res.add(0);
                    st.push(rev.val);
                }
            }
            rev = rev.next;
        }
        // step 3 — convert to array in reverse order
        int size  = res.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = res.get(size - i - 1);
        }
        return ans;
    }
}