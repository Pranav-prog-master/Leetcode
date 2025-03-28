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
#include <stdio.h>
#include <stdlib.h>

// Function to find two indices whose values add up to the target
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[j] == target - nums[i]) {
                int* result = (int*)malloc(2 * sizeof(int));
                result[0] = i;
                result[1] = j;
                *returnSize = 2; // Return the size of the result array
                return result;
            }
        }
    }
    *returnSize = 0; 
    return NULL;
}

int main() {
    int nums[] = {2, 7, 11, 15};
    int target = 9;
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    int returnSize;
    int* result = twoSum(nums, numsSize, target, &returnSize);

    if (result != NULL) {
        printf("Indices: %d, %d\n", result[0], result[1]);
        free(result); 
    } else {
        printf("No solution found.\n");
    }

    return 0;
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
#include <stdio.h>
#include <stdbool.h>

bool isPalindrome(int x) {
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

int main() {
    printf("%d\n", isPalindrome(121));  
    printf("%d\n", isPalindrome(-121)); 
    printf("%d\n", isPalindrome(10));   

    return 0;
}