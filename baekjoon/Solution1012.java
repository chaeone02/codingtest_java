package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1012 {
	static int T, M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			int answer = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			Queue<int[]> q = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 배추모임 세기 시작
					if (!visited[i][j] && map[i][j] == 1) {
						q.offer(new int[] {i,j});
						visited[i][j] = true;
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							int x = cur[1];
							int y = cur[0];
							for (int d = 0; d < 4; d++) {
								int ny = y + dy[d];
								int nx = x + dx[d];
								if (ny < 0 || ny >= N || nx < 0 || nx >= M)
									continue;
								if (map[ny][nx] != 1)
									continue;
								if (visited[ny][nx])
									continue;
								visited[ny][nx] = true;
								q.offer(new int[] {ny, nx});
							}
						}
						answer++;
					}
				}
			}
		System.out.println(answer);	
		}
	}
}
