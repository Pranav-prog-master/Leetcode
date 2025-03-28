//! ****** Day_1 *******
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
 
//? Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

//? Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

//? Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]
 
//? Constraints:
// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
 
//? Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

//?
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> twoSum(List<Integer> nums, int target) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) == target - nums.get(i)) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return new ArrayList<>(); 
    }
}

public class Complete_Java {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(7);
        nums.add(11);
        nums.add(15);

        int target = 9;

        Solution solution = new Solution();
        List<Integer> result = solution.twoSum(nums, target);

        if (!result.isEmpty()) {
            System.out.println("Indices: " + result.get(0) + ", " + result.get(1));
        } else {
            System.out.println("No solution found.");
        }
    }
}


//! ****** Day2 ******
//? Given an integer x, return true if x is a palindrome, and false otherwise.
//? Example 1:
// Input: x = 121 Output: true Explanation: 121 reads as 121 from left to right and from right to left. 
//? Example 2:
// Input: x = -121 Output: false Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome. 
//? Example 3:
// Input: x = 10 Output: false Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//? Constraints:
// -231 <= x <= 231 - 1

//?
class Complete_Java {
    public boolean isPalindrome(int x) {
        
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome(121));  
        System.out.println(solution.isPalindrome(-121)); 
        System.out.println(solution.isPalindrome(10));   
    }
}