import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map;
    Random rand;

    // Constructor: preprocess indices of each number
    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    // Pick random index of target in O(1)
    public int pick(int target) {
        List<Integer> indices = map.get(target);
        return indices.get(rand.nextInt(indices.size()));
    }
}
