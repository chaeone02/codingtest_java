package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2178 {

	static int N, M;
	static char[][] maze;
	static int[][] visited;
	static Queue<int[]> queue;
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];		
		visited = new int[N][M];
		answer = 1;
		for (int i = 0; i < N; i++) {
			String line = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j);
			}
		}
		
		queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0});
		visited[0][0] = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int y = cur[0];
			int x = cur[1];
			if (y == N-1 && x == M-1) {
				answer = visited[y][x];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				if (maze[ny][nx] != '1')
					continue;
				if (visited[ny][nx] != 0)
					continue;
				queue.offer(new int[] {ny, nx});
				visited[ny][nx] = visited[y][x] + 1;
			}
		}
		System.out.println(answer);
	}
}