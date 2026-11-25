
/*
Problem: String Compression (LeetCode 443)

Description:
You are given an array of characters chars.

Compress the array by replacing consecutive repeating characters
with the character followed by its count.

If the group's length is 1, append only the character.

If the group's length is greater than 1, append the character
followed by its count.

The compressed string must be stored in the original chars array.
Return the new length of the compressed array.

Note:
Group lengths of 10 or more must be split into individual digits.
Use only constant extra space in the optimal approach.

Example 1:
Input: chars = ['a','a','b','b','c','c','c']
Output: 6

Modified Array: ['a','2','b','2','c','3']

Example 2:
Input: chars = ['a']
Output: 1

Modified Array: ['a']

Example 3:
Input: chars = ['a','b','b','b','b','b','b','b','b','b','b','b','b']
Output: 4

Modified Array: ['a','b','1','2']

--------------------------------------------------

Approach 1: Brute Force (ArrayList + Two Pointers)

Explanation:
1. Create an ArrayList to store the compressed characters.
2. Use index to track the starting position of the current group.
3. Use i to traverse the array and count consecutive repeating characters.
4. When a different character is encountered:
   - Add the previous character to the ArrayList.
   - If count is greater than 1, convert it into a String.
   - Add each digit of the count individually.
5. Reset count for the next group.
6. Process the last group separately after the loop.
7. Copy the ArrayList elements back into the original chars array.
8. Return the size of the ArrayList.

Time Complexity: O(n)
Space Complexity: O(n) for the ArrayList.

--------------------------------------------------

Approach 2: Optimal (Two Pointers - In-place)

Explanation:
1. Initialize index = 0 as the write pointer.
2. Initialize count = 1 to count consecutive repeating characters.
3. Traverse the array using i from index 1.
4. If chars[i] equals chars[i-1], increment count.
5. Otherwise:
   - Write the previous character at chars[index].
   - If count is greater than 1, convert it into a String.
   - Write each digit of count into the original array.
   - Reset count to 1 for the next group.
6. After the loop, process the last group separately.
7. Return index, which represents the new compressed length.

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

package Strings;
import java.util.*;
public class StringCompression {

    // ------------------------- Approach 1: Brute Force (ArrayList) -------------------------

    public int compressBruteForce(char[] chars) {
        List<Character> list = new ArrayList<>();
        int index = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[index]) {
                count++;
            } 
            else {
                list.add(chars[index]);               // Add the current character
                String str = String.valueOf(count);   // Convert count into String

                // Add count digits only if count > 1
                if (count > 1) {
                    for (int k = 0; k < str.length(); k++) {
                        list.add(str.charAt(k));
                    }
                }
                // Move to the next group
                index = i;
                count = 1;
            }
        }

        // Process the last group
        list.add(chars[index]);
        String str = String.valueOf(count);
        if (count > 1) {
            for (int k = 0; k < str.length(); k++) {
                list.add(str.charAt(k));
            }
        }
        // Copy compressed characters back into the original array
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        return list.size();
    }


    // ------------------------- Approach 2: Optimal (Two Pointers) -------------------------

    public int compressOptimal(char[] chars) {
        int index = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } 
            else {
                // Write the previous character
                chars[index++] = chars[i - 1];

                // Convert count into String
                String str = String.valueOf(count);

                // Write count digits if count > 1
                if (count > 1) {
                    for (int k = 0; k < str.length(); k++) {
                        chars[index++] = str.charAt(k);
                    }
                }
                // Reset count for the next group
                count = 1;
            }
        }

        // Process the last group
        chars[index++] = chars[chars.length - 1];
        String str = String.valueOf(count);
        if (count > 1) {
            for (int k = 0; k < str.length(); k++) {
                chars[index++] = str.charAt(k);
            }
        }
        return index;
    }
}
