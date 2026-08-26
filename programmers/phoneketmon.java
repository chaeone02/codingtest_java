import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int mon : nums)
            set.add(mon);

        return Math.min(nums.length / 2, set.size());
    }
}