package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {

	static int N, M, R, C, L;
	static int[][] map;
	static int[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1 ,1};
	static int[][] info = {{1,1,1,1}, {1,1,0,0}, {0,0,1,1}, {1,0,0,1}, {0,1,0,1}, {0,1,1,0}, {1,0,1,0}};
	static int[] opp = {1,0,3,2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {R, C});
			visited[R][C] = 1;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int y = cur[0]; int x = cur[1];
				if (visited[y][x] >= L) {
					break;
				}
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == 0 || visited[ny][nx] != 0) 
						continue;
					// 연결되어있으면!!
					if (info[map[y][x] - 1][d] == 1 && info[map[ny][nx] - 1][opp[d]] == 1) {
						visited[ny][nx] = visited[y][x] + 1;
						q.offer(new int[] {ny, nx});
					}
				}	
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] != 0) count++;
				}
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}
