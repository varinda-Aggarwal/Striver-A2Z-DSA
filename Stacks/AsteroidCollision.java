
/*
Problem: Asteroid Collision

Description: We are given an array of asteroids. Each asteroid has a size and direction: 
- Positive value: Moving right.
- Negative value: Moving left.

When two asteroids collide:
- Smaller asteroid gets destroyed.
- If both have equal size, both get destroyed.
- Asteroids moving in the same direction never collide.

Return the state of asteroids after all collisions.

Example 1:
Input: asteroids = [5, 10, -5]
Output: [5, 10]

Example 2:
Input: asteroids = [8, -8]
Output: []

Example 3:
Input: asteroids = [10, 2, -5]
Output: [10]

--------------------------------------------------
Approach 1: Optimal (Using Stack)

Explanation:
1. Traverse each asteroid in the array.
2. Collision is possible only when:
   - Stack is not empty.
   - Current asteroid is moving left.
   - Top asteroid is moving right.
3. Compare the absolute size of the current asteroid with the top asteroid.
4. If current asteroid is larger, pop the stack and continue checking for more collisions.
5. If both are equal, pop the stack and destroy current.
6. If stack asteroid is larger, destroy current.
7. If current asteroid survives, push it into the stack.
8. Finally, convert the stack into an answer array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Stacks;
import java.util.Stack;
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int val = asteroids[i];
            if (val < 0) val = -val;

            // Check whether the current asteroid survives
            boolean isAlive = true;

            // Collision is possible only in this case
            while (!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0) {
                
                // Case 1: Current asteroid is larger
                if (val > st.peek()) {
                    st.pop();
                }

                // Case 2: Both asteroids have equal size
                else if (st.peek() == val) {
                    st.pop();
                    isAlive = false;
                }

                // Case 3: Stack asteroid is larger
                else {
                    isAlive = false;
                }

                // Stop if current asteroid is destroyed
                if (!isAlive) {
                    break;
                }
            }

            // Add current asteroid if it survives
            if (isAlive) {
                st.push(asteroids[i]);
            }
        }

        // Convert stack into result array
        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}
