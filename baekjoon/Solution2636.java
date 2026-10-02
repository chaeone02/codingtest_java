package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2636 {

    static int M, N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        int cheeseCount = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        int time = 0;
        int prevCheese = 0;

        while (cheeseCount > 0) {

            // 이번 시간 시작 전 치즈 개수
            prevCheese = cheeseCount;
            visited = new boolean[M][N];
            Queue<int[]> queue = new ArrayDeque<>();
            List<int[]> melt = new ArrayList<>();

            // (0, 0)은 항상 바깥 공기
            queue.offer(new int[]{0, 0});
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny < 0 || ny >= M || nx < 0 || nx >= N) {
                        continue;
                    }
                    if (visited[ny][nx]) {
                        continue;
                    }
                    visited[ny][nx] = true;
                    // 바깥 공기면 계속 탐색
                    if (map[ny][nx] == 0) {
                        queue.offer(new int[]{ny, nx});
                    }
                    // 치즈면 이번에 녹일 치즈
                    else if (map[ny][nx] == 1) {
                        melt.add(new int[]{ny, nx});
                    }
                }
            }

            // 이번 시간에 녹을 치즈를 한꺼번에 제거
            for (int[] cur : melt) {
                int y = cur[0];
                int x = cur[1];

                map[y][x] = 0;
                cheeseCount--;
            }

            time++;
        }

        System.out.println(time);
        System.out.println(prevCheese);
    }
}