package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA1868 {

    static int T, N;
    static char[][] map;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {1, 0, -1, -1, -1, 0, 1, 1};
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }
            count = 0;

            // 1. 0인 칸들 먼저 클릭
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] == '.') {
                        first(y, x);
                    }
                }
            }

            // 2. 아직 안 열린 칸들은 각각 1번씩 클릭
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (map[y][x] == '.') {
                        count++;
                        map[y][x] = (char) (countMine(y, x) + '0');
                    }
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }


    static void first(int y, int x) {

        // 현재 칸이 0이 아니면 시작하지 않음
        if (countMine(y, x) != 0) {
            return;
        }
        count++;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {y, x});
        map[y][x] = '0';
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cy = now[0];
            int cx = now[1];
            for (int d = 0; d < 8; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                    continue;
                }
                
                // 이미 열렸거나 지뢰면 패스
                if (map[ny][nx] != '.') {
                    continue;
                }

                int num = countMine(ny, nx);

                map[ny][nx] = (char) (num + '0');

                // 0이면 연쇄적으로 계속 퍼짐
                if (num == 0) {
                    q.offer(new int[] {ny, nx});
                }
            }
        }
    }


    static int countMine(int y, int x) {
        int num = 0;
        for (int d = 0; d < 8; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                continue;
            }
            if (map[ny][nx] == '*') {
                num++;
            }
        }
        return num;
    }
}