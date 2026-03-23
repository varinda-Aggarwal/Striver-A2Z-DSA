/*
Problem: Check if a string is palindrome using recursion

Approach:
Compare characters from both ends:
    s[i] and s[n-i-1]

If they are equal -> move pointer (i+1)
If any mismatch -> not palindrome

Base Case:
When i crosses middle (i >= n/2), string is palindrome

Time Complexity: O(n)
Space Complexity: O(n)  
*/

package Recursion;

public class StringIsPalindromeOrNot {
     //Driver function
    public boolean palindromeCheck(String s) {
       return isPalindrome(s,0,s.length());
    }

    // Recursive function
    public boolean isPalindrome(String s,int i,int n)
    {
        //base case: reached middle or exceeded
        if(i>=n/2) return true;

        // check if mismatch found -> not palindrome
        if(s.charAt(i)!=s.charAt(n-i-1))  return false;

        // recursive call for next character
        return isPalindrome(s,i+1,n);   
    }
}
