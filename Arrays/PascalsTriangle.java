/*
Problem: Pascal's Triangle

Description:
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it. 
First and last element of every row is always 1.

--------------------------------------------------
 APPROACH : BUILD ROW BY ROW
--------------------------------------------------
 For every row, first and last element is always 1.
 Every middle element is sum of two elements directly
 above it from previous row.

 Time Complexity  : O(n²) → every element calculated once
 Space Complexity : O(n²) → storing all elements of triangle

 Edge Cases:
 - numRows = 1   → return [[1]]
 - numRows = 2   → return [[1], [1,1]]
*/

package Arrays;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();

            row.add(1);     // first element always 1
            if (i > 1) {
                // calculate middle elements from previous row
                List<Integer> previousRow = ans.get(ans.size() - 1);
                for (int j = 1; j < i - 1; j++) {
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }

                row.add(1);   // last element always 1
            }
            ans.add(row);
        }
        return ans;
    }
}