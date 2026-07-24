//이중 for 문 -> 시간초과로 탈락
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int N = people.length;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N/2; i++) {
            for (int j = N - 1; j > i; j--) {
                if (visited[j] == false && (people[i] + people[j]) <= limit) {
                    visited[i] = true;
                    visited[j] = true;
                    answer += 1;
                    break;
                }
            }
        }
        for (boolean b : visited) {
            if (b == false) answer++;
        }
        return answer;
    }
}