// GPT
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int releaseDay = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        int count = 1;
        
        for(int i = 1; i < progresses.length; i++) {
            int finishDay = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            
            if (finishDay <= releaseDay) 
                count++;
            else {
                answer.add(count);
                releaseDay = finishDay;
                count = 1;
            }
        }
        
        answer.add(count); // 마지막 배포 묶음 추가
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}