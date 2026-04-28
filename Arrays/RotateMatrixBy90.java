/*
  Problem: Rotate Matrix by 90 Degrees (Clockwise)
 
  Description:
  Given an n x n 2D matrix, rotate it 90 degrees clockwise in-place.
 
  --------------------------------------------------
   APPROACH 1 : BRUTE FORCE
  --------------------------------------------------
   Create a new n x n matrix and place each element
   at its rotated position directly.
   For element at (i, j) in original matrix,
   its position in rotated matrix is (j, n-1-i).
 
   Time Complexity  : O(n²) → traverse every element once
   Space Complexity : O(n²) → extra matrix of same size
 
   Edge Cases:
   - Single element matrix  → no change
   - Already rotated matrix → rotates again
  
  --------------------------------------------------
   APPROACH 2 : OPTIMAL (Transpose + Reverse)
  --------------------------------------------------
   Rotating 90 degrees clockwise is equivalent to —
   Step 1 : Transpose the matrix (swap rows and columns)
   Step 2 : Reverse each row
 
   This avoids creating an extra matrix — everything
   is done in-place using only a temp variable.
 
   Time Complexity  : O(n²) → traverse every element once
   Space Complexity : O(1)  → in-place, no extra space
 
   Edge Cases:
   - Single element matrix  → no change
   - Already rotated matrix → rotates again
 */

package Arrays;

public class RotateMatrixBy90 {

//     -------------------- BRUTE FROCE APPROACH ---------------------

    public void rotateBrute(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        // place each element at its rotated position
        // element at (i, j) goes to (j, n-1-i) in rotated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n-1-i] = matrix[i][j];
            }
        }

        // copy rotated matrix back to original
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }

//     -------------------- OPTIMAL APPROACH ---------------------
    public void rotateOptimal(int[][] matrix) {
        int n = matrix.length;
        // step 1 — transpose the matrix
        // swap elements across the diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swapElements(matrix, i, j);
            }
        }

        // step 2 — reverse each row
        for (int i = 0; i < n; i++) {
            int left  = 0;
            int right = matrix[i].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // swap matrix[i][j] with matrix[j][i] for transpose
    private void swapElements(int[][] matrix, int rowIndex, int colIndex) {
        int temp = matrix[rowIndex][colIndex];
        matrix[rowIndex][colIndex] = matrix[colIndex][rowIndex];
        matrix[colIndex][rowIndex] = temp;
    }
}