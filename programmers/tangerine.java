import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> countMap = new HashMap<>();

        // 귤 크기별 개수 세기
        for (int size : tangerine) {
            countMap.put(size, getOrdefault(size, 0) + 1)
        }
        List<Integer> counts = new Arraylist<>(countMap.values());
        counts.sort(Collections.reverseOrder());

        for (int count : counts) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}
