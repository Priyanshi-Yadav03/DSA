import java.util.*;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> intervals = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int maxHeight = 0;

        for (int[] pos : positions) {
            int left = pos[0], size = pos[1], right = left + size;
            int height = 0;

            for (int[] interval : intervals) {
                int iLeft = interval[0], iRight = interval[1], iHeight = interval[2];
                if (iRight > left && iLeft < right) { // overlap
                    height = Math.max(height, iHeight);
                }
            }

            int newHeight = height + size;
            intervals.add(new int[]{left, right, newHeight});
            maxHeight = Math.max(maxHeight, newHeight);
            result.add(maxHeight);
        }

        return result;
    }
}
