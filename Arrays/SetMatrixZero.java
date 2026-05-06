/*
  Problem: Set Matrix Zeroes
 
  Description:
  Given an m x n matrix, if any element is 0, set its
  entire row and column to 0. This must be done in-place.
 
  --------------------------------------------------
   APPROACH 1 : BRUTE FORCE (Boolean Marker Matrix)
  --------------------------------------------------
   Create a 2D boolean marker matrix of same size.
   For every 0 found, mark its entire row and column
   as true in marker matrix. Then set zeroes in original
   matrix based on marker.
 
   Time Complexity  : O(n×m)   → traverse matrix twice
   Space Complexity : O(n×m)   → extra 2D boolean matrix
 
   Edge Cases:
   - No zero in matrix      → no change
   - All zeroes in matrix   → entire matrix becomes zero
   - Single element zero    → its row and column become zero
 
  --------------------------------------------------
   APPROACH 2 : BETTER (Two 1D Arrays)
  --------------------------------------------------
   Instead of a full 2D marker matrix, use two 1D boolean
   arrays — one for rows and one for columns.
   Mark which rows and columns contain zero in first pass.
   Set zeroes in second pass based on these arrays.
 
   Time Complexity  : O(n×m)   → traverse matrix twice
   Space Complexity : O(n+m)   → two 1D arrays for rows and cols
 
   Edge Cases:
   - No zero in matrix      → no change
   - All zeroes in matrix   → entire matrix becomes zero
   - Single element zero    → its row and column become zero
 
  --------------------------------------------------
   APPROACH 3 : OPTIMAL (First Row and Column as Marker)
  --------------------------------------------------
   Use the first row and first column of the matrix itself
   as markers — no extra space needed.
   Since first row and column are used as markers, we need
   two boolean flags to track if they originally had zeroes.
 
   Step 1 : Check if first row and first column have any zero
   Step 2 : Traverse rest of matrix — if zero found, mark
            its row in first column and column in first row
   Step 3 : Set zeroes based on markers in first row and col
   Step 4 : Handle first row and column separately using flags
 
   Time Complexity  : O(n×m)   → traverse matrix twice
   Space Complexity : O(1)     → no extra space used
 
   Edge Cases:
   - No zero in matrix      → no change
   - All zeroes in matrix   → entire matrix becomes zero
   - Single element zero    → its row and column become zero
 */

package Arrays;

public class SetMatrixZero{

     // ------------------ Brute Approach: Boolean Marker Matrix Approach ------------------

    // mark entire row as true in marker matrix
    private void markRowZero(boolean[][] marker, int rowIndex) {
        for (int j = 0; j < marker[0].length; j++) {
            marker[rowIndex][j] = true;
        }
    }

    // mark entire column as true in marker matrix
    private void markColZero(boolean[][] marker, int colIndex) {
        for (int i = 0; i < marker.length; i++) {
            marker[i][colIndex] = true;
        }
    }

    public void setMatrixZeroesBrute(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        // create 2D marker matrix to track which cells become zero
        boolean[][] marker = new boolean[rowSize][colSize];

        // mark rows and columns for every zero found
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    markRowZero(marker, i);
                    markColZero(marker, j);
                }
            }
        }

        // set zeroes in original matrix based on marker
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (marker[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // ------------------ Better Approach: Two 1D Arrays Approach ------------------

    public void setMatrixZeroesBetter(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        // track which rows and columns contain zero
        boolean[] zeroRows = new boolean[rowSize];
        boolean[] zeroCols = new boolean[colSize];

        // mark rows and columns that contain zero
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // set zeroes based on marked rows and columns
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    // ------------------ optimal Approach: First Row and Column as Marker Approach ------------------
    
    public void setMatrixZeroesOptimal(int[][] matrix) {

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        // flags to track if first row and first column had zero originally
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // check if first row has any zero
        for (int j = 0; j < colSize; j++) {
            if (matrix[0][j] == 0) firstRowHasZero = true;
        }

        // check if first column has any zero
        for (int i = 0; i < rowSize; i++) {
            if (matrix[i][0] == 0) firstColHasZero = true;
        }

        // use first row and column as marker for rest of matrix
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // mark row in first column
                    matrix[0][j] = 0;  // mark column in first row
                }
            }
        }

        // set zeroes in rest of matrix based on first row and column markers
        for (int i = 1; i < rowSize; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < colSize; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set zeroes in columns based on first row markers
        for (int j = 1; j < colSize; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rowSize; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // handle first row separately using flag
        if (firstRowHasZero) {
            for (int j = 0; j < colSize; j++) {
                matrix[0][j] = 0;
            }
        }

        // handle first column separately using flag
        if (firstColHasZero) {
            for (int i = 0; i < rowSize; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
