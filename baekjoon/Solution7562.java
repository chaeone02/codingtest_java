package cw;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution7562 {
	static int l, sx, sy, ex, ey;
	static int[] dy = new int[] {-1,-2,-2,-1,1,2,2,1};
	static int[] dx = new int[] {2,1,-1,-2,-2,-1,1,2};
	static Queue<int[]> q;
	static int[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			l = sc.nextInt();
			sx = sc.nextInt(); sy = sc.nextInt();
			ex = sc.nextInt(); ey = sc.nextInt();
			q = new ArrayDeque<>();
			visited = new int[l][l];
			int answer = -1;
			q.offer(new int[] {sy,sx});
			visited[sy][sx] = 1;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[1]; int y = cur[0];
				if (x == ex && y == ey) {
					answer = visited[y][x] - 1;
					break;
				}
				
				for (int d = 0; d < 8; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (ny < 0 || ny >= l || nx < 0 || nx >= l)
						continue;
					if (visited[ny][nx] != 0)
						continue;
					q.offer(new int[] {ny,nx});
					visited[ny][nx] = visited[y][x] + 1;
				}
			}
			System.out.println(answer);
		}
	}
}
