/*
  Problem: Spiral Matrix
 
  Description:
  Given an m x n matrix, return all elements of the matrix in spiral order.
 
  --------------------------------------------------
   APPROACH : FOUR POINTERS
  --------------------------------------------------
   Use four pointers — top, right, bottom, left — to track the boundaries of the matrix.
   In each iteration shrink the boundary after traversing that side.
 
   - top    → current top row    (traverse left to right)
   - right  → current right col  (traverse top to bottom)
   - bottom → current bottom row (traverse right to left)
   - left   → current left col   (traverse bottom to top)
 
   Extra check before bottom and left traversal to avoid duplicates in case of single row or single column left.
 
   Time Complexity  : O(n×m) → every element visited once
   Space Complexity : O(1)   → excluding result list
 
   Edge Cases:
   - Single row matrix      → only left to right traversal
   - Single column matrix   → only top to bottom traversal
   - Single element matrix  → returns that element
  --------------------------------------------------
 */

package Arrays;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top    = 0;                     // tracks current top row
        int right  = matrix[0].length - 1;  // tracks current right column
        int bottom = matrix.length - 1;     // tracks current bottom row
        int left   = 0;                     // tracks current left column

        while (top <= bottom && left <= right) {

            // step 1 — traverse top row from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // step 2 — traverse right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // step 3 — traverse bottom row from right to left
            // check needed to avoid duplicate traversal in single row case
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // step 4 — traverse left column from bottom to top
            // check needed to avoid duplicate traversal in single column case
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}