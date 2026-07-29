import java.util.*;
import java.io.*;

class Solution {
	static int T;
	static int N;
	static int[][] maps;
	static int A,B,C,D;
	static int result;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= N; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			maps = new int[N][N];
			for (int i = 0; i < N; i++) {
				// 한 줄의 공백을 입력받는다
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			result = bfs();
			System.out.println("#" + tc + " " + result);
			
		}
	}
	
	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {A,B});
		maps[A][B] = 1;
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			
			int r = p[0];
			int c = p[1];
			
			if (r == C && c == D) 
				return maps[r][c] - 1;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!check(nr, nc)) continue;
				
				//0인 곳만 이동가능, 1은 장애물, 2이상은 이미 방문
				if (maps[nr][nc] != 0) continue;
				maps[nr][nc] = maps[r][c] + 1;
				queue.offer(new int[] {nr, nc});
			}
		}
		return -1;
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}