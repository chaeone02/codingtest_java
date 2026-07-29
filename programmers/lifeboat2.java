// 투 포인터로 풀어야 시간 초과 안남

// 핵심 아이디어 : 가장 무거운 사람은 언젠가는 보내야 함
// 그 사람 보낼때 -> 가장 가벼운 사람도 껴서 보낼 수 있는지!

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}