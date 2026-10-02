package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7576 {
	static int M, N, x, y;
	static int[][] map;
	static int[][] visited;
	static Queue<int[]> q;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					q.offer(new int[] {i, j});
					visited[i][j] = 1;
				}
				else if (temp == -1) {
					visited[i][j] = -1;
				}
			}
		}

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[1]; 
			int cy = cur[0];
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if (visited[ny][nx] != 0)
					continue;
				q.offer(new int[] {ny, nx});
				visited[ny][nx] = visited[cy][cx] + 1;
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				answer = Math.max(answer, visited[i][j]);
			}
		}
		System.out.println(answer-1);
	}
}