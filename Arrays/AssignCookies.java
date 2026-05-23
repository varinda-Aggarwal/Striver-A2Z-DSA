/*
Problem: Assign Cookies

Description:
Given an array g of children's greed factors and an array's of cookie sizes, 
find the maximum number of children that can be content. A child is content if they get a cookie greater than or equal to their greed factor.
Each child can get at most one cookie.

--------------------------------------------------
 APPROACH 1 : BRUTE FORCE (Boolean Marking)
--------------------------------------------------
 For every child, search entire cookie array and assign first available cookie that satisfies their greed.
 Mark used cookies with boolean array.

 Time Complexity  : O(n×m) → nested loop
 Space Complexity : O(m)   → boolean marker array

 Edge Cases:
 - No cookies → return 0
 - No children → return 0
 - All cookies too small → return 0

--------------------------------------------------
 APPROACH 2 : OPTIMAL (Sorting + Two Pointer)
--------------------------------------------------
 Sort both arrays. Use two pointers — one for children and one for cookies. 
 If current cookie satisfies current child, move both pointers. Otherwise only move cookie pointer to try next bigger cookie.
 This ensures smallest valid cookie is used for each child leaving bigger cookies for greedier children.

 Time Complexity : O(n log n + m log m) → sorting
 Space Complexity : O(1) → only two pointers used

 Edge Cases:
 - No cookies → return 0
 - No children → return 0
 - All cookies too small → return 0
*/

package Arrays;
import java.util.Arrays;

public class AssignCookies {

    // --------------------------- BRUTE FORCE APPROACH ---------------------------

    public int findContentChildrenBrute(int[] g, int[] s) {
        boolean[] used = new boolean[s.length];
        int count = 0;
        // for every child find first available valid cookie
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (g[i] <= s[j] && !used[j]) {
                    count++;
                    used[j] = true;
                    break;
                }
            }
        }
        return count;
    }

    // --------------------------- OPTIMAL APPROACH ---------------------------

    public int findContentChildrenOptimal(int[] g, int[] s) {
        // sort both arrays
        Arrays.sort(g);
        Arrays.sort(s);
        
        int count = 0;
        int i = 0;  // pointer for children
        int j = 0;  // pointer for cookies
        while (i < g.length && j < s.length) {
            // current cookie satisfies current child
            if(g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } 
            else {
                j++;     // cookie too small — try next bigger cookie
            }
        }
        return count;
    }
}