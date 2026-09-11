package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14940 {

	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[][] answer;
	static Queue<int[]> q;
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};
	static int desty, destx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = new int[N][M];
		desty = -1; destx = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					desty = i; destx = j;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					answer[i][j] = bfs(i,j);
				}
				else if (map[i][j] == 2 || map[i][j] == 0) {
					answer[i][j] = 0;
				}
				else
					answer[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static int bfs(int y, int x) {
		q = new ArrayDeque<>();
		visited = new int[N][M];
		q.offer(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			if (curY == desty && curX == destx) {
				return visited[curY][curX];
			}
			for (int d = 0; d < 4; d++) {
				int ny = curY + dy[d];
				int nx = curX + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				if (map[ny][nx] == 0)
					continue;
				if (visited[ny][nx] != 0)
					continue;
				q.offer(new int[] {ny, nx});
				visited[ny][nx] = visited[curY][curX] + 1;
			}
		}
		return -1;
	}
}