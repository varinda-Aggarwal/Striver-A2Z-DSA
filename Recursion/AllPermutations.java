/*
Problem: Permutations

Description:
Given an array of distinct integers, return all possible permutations.
A permutation is an arrangement of all elements in a unique order.

Example:
Input  : [1, 2, 3]
Output :
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

--------------------------------------------------
Approach 1: Backtracking using Visited Array
--------------------------------------------------
- Create a boolean visited[] array to keep track of which elements
  have already been included in the current permutation.
- Use a Stack (or List) to store the current permutation.
- Iterate through every element:
    • If it has not been visited,
      mark it as visited and add it to the current permutation.
    • Recursively generate the remaining permutation.
    • After recursion, backtrack by removing the element and
      marking it as unvisited.
- When the current permutation contains all n elements,
  add a copy of it to the final answer.

Time Complexity  : O(n × n!)
Space Complexity : O(n)          // Excluding output
                   O(n × n!)     // Including output storage

Why Optimal?
- There are n! possible permutations.
- Every permutation must be generated and stored.
- Therefore, no algorithm can have a better time complexity
  than O(n × n!).
- Backtracking efficiently explores only valid permutations.

Edge Cases:
- Single element array
- Two element array
- Empty array
- Distinct elements only

--------------------------------------------------
Approach 2: Backtracking using In-place Swapping
--------------------------------------------------
(Not implemented here)

- Fix one position at a time.
- Swap the current element with every possible element.
- Recursively generate permutations for the remaining positions.
- Backtrack by swapping the elements back.

Time Complexity  : O(n × n!)
Space Complexity : O(n)          // Recursion stack only (excluding output)

This approach is more space-efficient since it modifies the input
array in-place and does not require a visited array.
*/

package Recursion;
import java.util.*;
public class AllPermutations {

    // ---------------------------- Backtracking Helper ---------------------------

    private void generatePermutations(int[] nums, boolean[] visited, Stack<Integer> currentPermutation, List<List<Integer>> result) {
        // Base Case: If the current permutation contains all elements, store a copy in the result.
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        // Try every element
        for (int i = 0; i < nums.length; i++) {
            // Skip already used elements
            if (!visited[i]) {
                // Choose
                visited[i] = true;
                currentPermutation.push(nums[i]);
                // Explore
                generatePermutations(nums, visited, currentPermutation, result);
                // Backtrack
                currentPermutation.pop();
                visited[i] = false;
            }
        }
    }

    // ------------------ Backtracking using Visited Array ------------------

    public List<List<Integer>> permute(int[] nums) {
        // Stores all permutations
        List<List<Integer>> result = new ArrayList<>();
        
        // Tracks whether an element has already been used
        boolean[] visited = new boolean[nums.length];

        // Stores the current permutation
        Stack<Integer> currentPermutation = new Stack<>();
        
        generatePermutations(nums, visited, currentPermutation, result);
        return result;
    }
}