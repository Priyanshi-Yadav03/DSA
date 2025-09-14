import java.util.*;

class Solution {
    int[] nums;
    Random rand;

    // Constructor (LeetCode 398 - Random Pick Index)
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    // Random Pick Index using Reservoir Sampling
    public int pick(int target) {
        int result = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) { // 1/count probability
                    result = i;
                }
            }
        }
        return result;
    }

    // Find the Difference (LeetCode 389)
    public char findTheDifference(String s, String t) {
        char xor = 0;
        for (char c : s.toCharArray()) {
            xor ^= c;
        }
        for (char c : t.toCharArray()) {
            xor ^= c;
        }
        return xor;
    }
}
