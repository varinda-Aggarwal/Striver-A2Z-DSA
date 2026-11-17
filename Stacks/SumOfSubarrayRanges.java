
/*
Problem: Sum of Subarray Ranges

Description: Given an integer array nums, find the sum of ranges of all possible subarrays. Range of a subarray = Maximum element - Minimum element.

Example 1:
Input: nums = [1, 2, 3]
Output: 4

Explanation:
[1] -> 0
[2] -> 0
[3] -> 0
[1, 2] -> 1
[2, 3] -> 1
[1, 2, 3] -> 2

Total = 4

--------------------------------------------------
Approach 1: Brute Force

Explanation:
1. Generate every possible subarray using two loops.
2. Initialize min and max for every starting index.
3. Update minimum and maximum while expanding the subarray.
4. Calculate max - min and add it to sum.

Time Complexity: O(n²)
Space Complexity: O(1)

--------------------------------------------------
Approach 2: Optimal (Contribution Technique + Monotonic Stack)

Explanation:
1. Calculate the sum of minimums of all subarrays.
2. Calculate the sum of maximums of all subarrays.
3. For minimum contribution, find PSE and NSE.
4. For maximum contribution, find PGE and NGE.
5. Calculate the contribution of every element: Contribution = Element * Left Choices * Right Choices
6. Return: Sum of Maximums - Sum of Minimums

Time Complexity: O(n)
Space Complexity: O(n)
*/

package Stacks;
import java.util.Stack;
public class SumOfSubarrayRanges {

    // --------------------------------- Brute Force Approach -------------------------------------

    public long subArrayRangesBruteForce(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (long) max - min;
            }
        }
        return sum;
    }

    // ---------------------------------- Optimal Approach -------------------------------------

    public long subarrayMins(int[] nums) {
        int[] NSE = new int[nums.length];
        int[] PSE = new int[nums.length];

        Stack<Integer> pse = new Stack<>();

        // Find Previous Smaller Element
        for (int i = 0; i < nums.length; i++) {
            while (!pse.isEmpty() && nums[pse.peek()] >= nums[i]) {
                pse.pop();
            }
            PSE[i] = pse.isEmpty() ? -1 : pse.peek();
            pse.push(i);
        }

        Stack<Integer> nse = new Stack<>();

        // Find Next Smaller Element
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!nse.isEmpty() && nums[nse.peek()] > nums[i]) {
                nse.pop();
            }
            NSE[i] = nse.isEmpty() ? nums.length : nse.peek();
            nse.push(i);
        }

        long sum = 0;

        // Calculate minimum contribution
        for (int i = 0; i < nums.length; i++) {
            long l = i - PSE[i];
            long r = NSE[i] - i;
            long contribution = (long) nums[i] * l * r;
            sum += contribution;
        }
        return sum;
    }

    // Find sum of subarray maximums
    public long subarrayMax(int[] nums) {
        int[] NGE = new int[nums.length];
        int[] PGE = new int[nums.length];

        Stack<Integer> pge = new Stack<>();

        // Find Previous Greater Element
        for (int i = 0; i < nums.length; i++) {
            while (!pge.isEmpty() && nums[pge.peek()] <= nums[i]) {
                pge.pop();
            }
            PGE[i] = pge.isEmpty() ? -1 : pge.peek();
            pge.push(i);
        }

        Stack<Integer> nge = new Stack<>();

        // Find Next Greater Element
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!nge.isEmpty() && nums[nge.peek()] < nums[i]) {
                nge.pop();
            }
            NGE[i] = nge.isEmpty() ? nums.length : nge.peek();
            nge.push(i);
        }

        long sum = 0;

        // Calculate maximum contribution
        for (int i = 0; i < nums.length; i++) {
            long l = i - PGE[i];
            long r = NGE[i] - i;
            long contribution = (long) nums[i] * l * r;
            sum += contribution;
        }
        return sum;
    }

    // Optimal: Sum of maximums - Sum of minimums
    public long subArrayRanges(int[] nums) {
        long minSum = subarrayMins(nums);
        long maxSum = subarrayMax(nums);
        return maxSum - minSum;
    }
}
