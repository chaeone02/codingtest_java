import java.util.*;

class Solution {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int startR, startC;
    static int endR, endC;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r;
        int c;
        int time;

        Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            // 수영장 크기
            N = sc.nextInt();

            map = new int[N][N];
            visited = new boolean[N][N];

            // 수영장 지도 입력
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }

            // 시작 위치
            startR = sc.nextInt();
            startC = sc.nextInt();

            // 도착 위치
            endR = sc.nextInt();
            endC = sc.nextInt();

            int answer = bfs();

            System.out.println("#" + tc + " " + answer);
        }

        sc.close();
    }

    static int bfs() {

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(startR, startC, 0));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {

            Node cur = queue.poll();

            // 도착점에 도착했다면 현재 시간 반환
            if (cur.r == endR && cur.c == endC) {
                return cur.time;
            }

            boolean wait = false;

            // 상하좌우 탐색
            for (int d = 0; d < 4; d++) {

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int nextTime = cur.time + 1;

                // 수영장 범위를 벗어남
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                // 장애물
                if (map[nr][nc] == 1) {
                    continue;
                }

                // 이미 방문한 위치
                if (visited[nr][nc]) {
                    continue;
                }

                // 일반 물
                if (map[nr][nc] == 0) {

                    visited[nr][nc] = true;
                    queue.offer(new Node(nr, nc, nextTime));
                }

                // 소용돌이
                else if (map[nr][nc] == 2) {

                    // 소용돌이가 사라진 시간에만 이동
                    if (nextTime % 3 == 0) {

                        visited[nr][nc] = true;
                        queue.offer(new Node(nr, nc, nextTime));

                    } else {
                        // 현재 위치에서 기다릴 필요가 있음
                        wait = true;
                    }
                }
            }

            // 소용돌이 때문에 이동하지 못한 경우 현재 위치에서 1초 대기
            if (wait) {
                queue.offer(new Node(cur.r, cur.c, cur.time + 1));
            }
        }

        return -1;
    }
}