// 해시맵 x , 리스트를 이용한 게 더 간단한 풀이
// 배열의 인덱스 또한 활용할 수 있다는 점 기억 !!!!!!!!!
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

            int[] count = new int[101];

            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                count[score]++;
            }

            int answer = 0;
            int maxCount = 0;

            // 작은 점수부터 검사
            for (int score = 0; score <= 100; score++) {
                if (count[score] >= maxCount) {
                    maxCount = count[score];
                    answer = score;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}