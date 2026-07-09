/*
Problem: Pascal's Triangle II

Description:
Given an integer rowIndex, return the rowIndex th row of Pascal's triangle (0-indexed).

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Store All Rows)
--------------------------------------------------
 Build entire Pascal's triangle up to rowIndex and return last row. Stores all rows unnecessarily.

 Time Complexity  : O(n²) → build entire triangle
 Space Complexity : O(n²) → stores all rows

 Edge Cases:
 - rowIndex = 0 → return [1]
 - rowIndex = 1 → return [1, 1]
--------------------------------------------------

--------------------------------------------------
 APPROACH 2 : OPTIMAL (Track Only Current Row)
--------------------------------------------------
 Instead of storing all rows, only keep track of current row. Each row is calculated from previous row and previous row reference is replaced.

 Time Complexity  : O(n²) → calculate each row
 Space Complexity : O(n)  → only current row stored

 Edge Cases:
 - rowIndex = 0 → return [1]
 - rowIndex = 1 → return [1, 1]
--------------------------------------------------
*/

package Arrays;
import java.util.ArrayList;
import java.util.List;
public class PascalsTriangleII {

    // ---------------------------- Brute Force Approach --------------------

    public List<Integer> getRowBrute(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if (i > 0) {
                List<Integer> previousRow = ans.get(ans.size() - 1);
                for (int j = 1; j < i; j++) {
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }
                row.add(1);
            }
            ans.add(row);
        }
        return ans.get(ans.size() - 1);
    }

    // ---------------------------- Optimal Approach --------------------

    public List<Integer> getRowOptimal(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if (i > 0) {
                // calculate from previous row stored in ans
                for (int j = 1; j < i; j++) {
                    row.add(ans.get(j - 1) + ans.get(j));
                }
                row.add(1);
            }
            // replace ans with current row — previous row discarded
            ans = row;
        }
        return ans;
    }
}