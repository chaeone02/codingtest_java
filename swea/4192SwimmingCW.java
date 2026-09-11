package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA4192 {

	static int tc;
	static int N;
	static int A, B, C, D;
	static int x, y;
	static String[][] map;
	static int[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < tc; i++) {
			// 1. 변수 파싱
			N = Integer.parseInt(br.readLine().trim());
			map = new String[N][N];
			visited = new int[N][N];
			count = -1;
			for (int j = 0; j < N; j++) {
				String s = br.readLine().trim();
				map[j] = s.split(" ");
			}
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			// 2. 이동로직
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[]{A,B});
			visited[A][B]= 1;
			while(!q.isEmpty()) {
				int[] cur = q.poll(); 
				int y = cur[0];
				int x = cur[1];
				
				if (y == C && x == D) {
					count = visited[y][x] - 1;
					break;
				}
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[ny][nx]== 0 && map[ny][nx].equals("0")) {
						q.offer(new int[] {ny,nx});
						visited[ny][nx] = visited[y][x] + 1;
					}
				}
			}
			System.out.println("#" + (i+1)+ " "+ count);
		}
	}
}
