/*
Problem: Count number of digits in a given integer
Approach: Repeatedly divide number by 10 until it becomes 0
Time Complexity: O(log10 n)
Space Complexity: O(1)
*/


package Basics;

public class CountDigits {

    public static int countDigit(int n) {
        if (n == 0) return 1;

        int count = 0;
        n = Math.abs(n);  // handles negative numbers

        while (n > 0) {
            n = n / 10;
            count++;
        }

        return count;
    }
}

