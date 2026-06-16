/*
Problem: Happy Number

Description:
A happy number is defined by the following process: 
Starting with any positive integer, replace the number by the sum of squares of its digits. 
Repeat the process until the number equals 1 (happy) or loops endlessly in a cycle (not happy). 
Return true if happy, false otherwise.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (HashSet)
--------------------------------------------------
 Store every number seen in HashSet. If number
 repeats — cycle detected — return false.
 If reaches 1 — return true.

 Time Complexity  : O(log n) → digits calculation
 Space Complexity : O(n)     → HashSet stores numbers

 Edge Cases:
 - n = 1 → return true directly
 - Cycle exists → HashSet detects repeat

--------------------------------------------------
 APPROACH 2 : OPTIMAL (Slow Fast Pointer)
--------------------------------------------------
 Use Floyd's cycle detection — slow moves 1 step and fast moves 2 steps in the number sequence.
 If cycle exists slow and fast will meet. If reaches 1 — happy number.

 Time Complexity  : O(log n) → digits calculation
 Space Complexity : O(1) → only two pointers

 Edge Cases:
 - n = 1 → fast starts at 1 → return true
 - Cycle exists → slow meets fast → return false
--------------------------------------------------
*/

package Arrays;
import java.util.HashSet;
public class HappyNumber {

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappyBrute(int n) {
        HashSet<Integer> visited = new HashSet<>();
        while (n != 1) {
            // cycle detected
            if (visited.contains(n)) return false;
            visited.add(n);
            n = getNext(n);
        }
        return true;
    }


    public boolean isHappyOptimal(int n) {
        int slow = n;
        int fast = getNext(n);
        // slow 1 step fast 2 steps
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        // fast reached 1 — happy number
        return fast == 1;
    }
}