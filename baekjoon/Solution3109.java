package cw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3109 {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		visited = new boolean [R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			if (dfs(i,0)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static boolean dfs(int y, int x) {
		if (x == C-1) {
			return true;
		}
		if (y-1 >= 0 && !visited[y-1][x+1] && map[y-1][x+1] != 'x') {
			visited[y-1][x+1] = true;
			if (dfs(y-1, x+1)) {
				return true;
			}
		}
		if (!visited[y][x+1] && map[y][x+1] != 'x') {
			visited[y][x+1] = true;
			if (dfs(y, x+1)) {
				return true;
			}
		}
		if (y+1 < R && !visited[y+1][x+1] && map[y+1][x+1] != 'x') {
			visited[y+1][x+1] = true;
			if (dfs(y+1, x+1)) {
				return true;
			}
		}
		return false;
	}
}