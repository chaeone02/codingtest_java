// gpt ; hashmap 유지하며 간소화
package algo;

import java.io.*;
import java.util.*;

public class Mode {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Map<Integer, Integer> countMap = new HashMap<>();

            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                countMap.put(score, countMap.getOrDefault(score, 0) + 1); //getOrD로 한번에 map까지 생성
            }

            int maxCount = 0;
            int answer = 0;

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int score = entry.getKey();
                int count = entry.getValue();

                if (count > maxCount) { //최빈값 로직도 간소화
                    maxCount = count;
                    answer = score;
                } else if (count == maxCount) {
                    answer = Math.max(answer, score);
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}