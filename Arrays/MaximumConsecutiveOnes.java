/*
Problem: Max Consecutive Ones

Description:
Given a binary array nums, return the maximum number of consecutive 1s.

Approach:
- Traverse the array once
- Maintain a counter for current streak of 1s
- Reset counter when a 0 is encountered
- Track the maximum streak found

Time Complexity: O(n)
Space Complexity: O(1)
*/

package Arrays;
class MaximunConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxConsecutiveOnes = 0;  // stores the maximum streak
        int currentStreak = 0;       // stores current streak of 1s

        for (int num : nums) {
            if (num == 1) {
                currentStreak++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentStreak);
            } 
            else {
                currentStreak = 0;
            }
        }
        return maxConsecutiveOnes;
    }
}