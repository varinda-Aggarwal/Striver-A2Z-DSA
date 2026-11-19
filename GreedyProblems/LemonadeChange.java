
/*
Problem: Lemonade Change
Description: At a lemonade stand, each lemonade costs $5. Customers are standing in a queue and buying one lemonade at a time. Each customer pays with either a $5, $10, or $20 bill.
Initially, we have no change. Return true if we can provide the correct change to every customer, otherwise return false.

Example 1:
Input: bills = [5, 5, 5, 10, 20]
Output: true

Example 2:
Input: bills = [5, 5, 10, 10, 20]
Output: false

--------------------------------------------------
Approach: Optimal (Greedy + Frequency Count)

Explanation:
1. Maintain two variables: countFive = Number of available $5 bills. countTen = Number of available $10 bills.
2. If customer gives $5: Accept the bill and increment countFive.
3. If customer gives $10: Give one $5 bill as change. Decrease countFive and increment countTen.
4. If customer gives $20: Prefer giving one $10 and one $5. Otherwise, give three $5 bills. If neither is possible, return false.
5. If all customers receive correct change, return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

package GreedyProblems;
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;
        for (int i = 0; i < bills.length; i++) {

            // Customer pays $5
            if (bills[i] == 5) {
                countFive++;
            }

            // Customer pays $10
            else if (bills[i] == 10) {
                if (countFive == 0) {
                    return false;
                }
                countFive--;
                countTen++;
            }

            // Customer pays $20
            else {
                // Prefer $10 + $5
                if (countFive > 0 && countTen > 0) {
                    countFive--;
                    countTen--;
                }
                // Otherwise, give three $5 bills
                else if (countFive >= 3) {
                    countFive -= 3;
                }
                // Cannot provide change
                else {
                    return false;
                }
            }
        }
        return true;
    }
}