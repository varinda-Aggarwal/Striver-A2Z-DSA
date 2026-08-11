/*
Problem: String to Integer (atoi)
Description:
Implement the myAtoi(String s) function, which converts a string into a 32-bit signed integer.

The conversion follows these rules:
1. Ignore leading whitespace.
2. Check for an optional '+' or '-' sign.
3. Read digits until a non-digit character is encountered.
4. If the number exceeds the 32-bit signed integer range, return Integer.MAX_VALUE or Integer.MIN_VALUE.
5. If no valid conversion can be performed, return 0.

Example 1:
Input  : "42"
Output : 42

Example 2:
Input  : "   -42"
Output : -42

Example 3:
Input  : "4193 with words"
Output : 4193

Example 4:
Input  : "words and 987"
Output : 0

--------------------------------------------------
Approach: Optimal (Single Traversal + Overflow Check)
--------------------------------------------------
- Use an index to skip leading spaces instead of using trim().
- Check for the optional sign.
- Traverse the digits only once.
- Before adding every digit, check whether the result would overflow the integer range.
- Stop as soon as a non-digit character is encountered.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- The string is traversed only once.
- No extra String or data structure is created.
- Overflow is checked before performing the arithmetic operation.

Edge Cases:
- Leading spaces
- Positive sign '+'
- Negative sign '-'
- No digits
- Non-digit characters after valid digits
- Positive overflow
- Negative overflow
- String containing only spaces
*/

package Strings;
public class StringToIntegerAtoi {

    // ------------------------ Optimal Approach ------------------------

    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        // Step 1: Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // Step 2: Handle sign
        boolean positive = true;
        if (i < n && s.charAt(i) == '-') {
            positive = false;
            i++;
        }
        else if (i < n && s.charAt(i) == '+') {
            i++;
        }
        // Step 3: Convert digits
        int ans = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // Step 4: Check for overflow before updating ans
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                if (positive) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
            ans = ans * 10 + digit;
            i++;
        }

        // Step 5: Apply sign
        if (!positive) {
            return -ans;
        }
        return ans;
    }
}