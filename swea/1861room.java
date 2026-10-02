package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static int N;
    static int[][] map;
    static int[][] pos;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            pos = new int[N * N + 1][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    int num = map[i][j];
                    pos[num][0] = i;
                    pos[num][1] = j;
                }
            }

            int start = 1; // 현재 확인 중인 방 번호
            int currentStart = 1; // 현재 연속 구간의 시작 번호
            int count = 1; // 현재까지 이동한 방 개수
            int answerStart = 1;
            int answerCount = 1;
            int y = pos[start][0];
            int x = pos[start][1];


            while (start <= N * N) {

                boolean flag = false;
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N)
                        continue;
                    if (map[ny][nx] == start + 1) {
                    	flag = true;
                        y = ny; x = nx;
                        start++;
                        count++;
                        break;
                    }
                }

                if (!flag) {

                    if (count > answerCount) {
                        answerCount = count;
                        answerStart = currentStart;
                    } else if (count == answerCount) {
                        answerStart = Math.min(answerStart, currentStart);
                    }
                    start++;
                    currentStart = start;
                    count = 1;
                    if (start <= N * N) {
                        y = pos[start][0];
                        x = pos[start][1];
                    }
                }
            }
            System.out.println( "#" + tc + " " + answerStart + " " + answerCount);
        }
    }
}