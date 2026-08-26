import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] release = new int[progresses.length];
        boolean[] visited = new boolean[release.length];
        
        for (int i = 0; i < progresses.length; i++) {
            release[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        
        for (int j = 0; j < release.length; j++) {
            if (visited[j] == true) 
                continue;
            visited[j] = true;
            int temp = 1;
            if (j != release.length - 1) {
                for (int k = j + 1; k < release.length; k++) {
                    if (release[k] > release[j]) 
                        break;
                    else {
                        visited[k] = true;
                        temp++;
                    }
                }
            }
            list.add(temp);
        }
        int[] answer = new int[list.size()];
        int num = 0;
        for (int i : list)
            answer[num++] = i;
        return answer;
    }
}