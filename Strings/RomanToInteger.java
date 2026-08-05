/*
Problem: Roman to Integer

Description:
Roman numerals are represented by seven different symbols:
I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000

Given a Roman numeral, convert it to an integer. Roman numerals are usually written from largest to smallest. However, in certain cases, a smaller numeral appears before a larger numeral to indicate subtraction.

Examples:
IV  = 4
IX  = 9
XL  = 40
XC  = 90
CD  = 400
CM  = 900

Example 1:
Input  : "III"
Output : 3

Example 2:
Input  : "LVIII"
Output : 58

Example 3:
Input  : "MCMXCIV"
Output : 1994

--------------------------------------------------
Approach: Optimal (Single Traversal - Right to Left)
--------------------------------------------------
- Traverse the Roman numeral from right to left.
- Maintain the value of the previous Roman numeral.
- Convert the current Roman symbol into its integer value.
- If the current value is smaller than the previous value, subtract it from the answer.
- Otherwise, add it to the answer.
- Update the previous value with the current value.

Time Complexity  : O(n)
Space Complexity : O(1)

Why Optimal?
- Each character is processed exactly once.
- Only one Roman value lookup is performed per character.
- Uses constant extra space.
- Avoids repeatedly looking ahead to the next character.

Edge Cases:
- Single Roman numeral
- Largest valid Roman numeral
- All subtractive combinations
- Repeated symbols
*/

package Strings;
public class RomanToInteger {

    // ------------------------ Helper Function ----------------------------

    // Returns the integer value of a Roman numeral
    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    // ------------------ Optimal Approach ------------------

    public int romanToInt(String s) {
        int sum = 0;
        int previousValue = 0;
        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = getValue(s.charAt(i));
            // If current value is smaller than previous, it forms a subtractive pair.
            if (currentValue < previousValue) {
                sum -= currentValue;
            }
            else {
                sum += currentValue;
            }
            // Update previous value
            previousValue = currentValue;
        }
        return sum;
    }
}