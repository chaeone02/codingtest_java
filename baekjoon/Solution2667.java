package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Solution2667 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		ArrayList<Integer> answer = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int count = 0;
				if (visited[i][j]) 
					continue;
				if (map[i][j] == 1) {
					// 연결된 단지 탐색 시작
					visited[i][j] = true;
					count++;
					queue.offer(new int[] {i, j});
					while (!queue.isEmpty()) {
						int[] h = queue.poll();
						int y = h[0];
						int x = h[1];
						// 범위 내에서 사방 탐색
						// 1있으면 다 큐에 넣고,방문처리, 단지수증가
						if (x+1 < N && map[y][x+1] == 1 && !visited[y][x+1]) {
							queue.offer(new int[] {y, x+1});
							visited[y][x+1] = true;
							count++;
						}
						if (x-1 >= 0 && map[y][x-1] == 1 && !visited[y][x-1]) {
							queue.offer(new int[] {y, x-1});
							visited[y][x-1] = true;
							count++;
						}
						if (y+1 < N && map[y+1][x] == 1 && !visited[y+1][x]) {
							queue.offer(new int[] {y+1, x});
							visited[y+1][x] = true;
							count++;
						}
						if (y-1 >= 0 && map[y-1][x] == 1 && !visited[y-1][x]) {
							queue.offer(new int[] {y-1, x});
							visited[y-1][x] = true;
							count++;
						}
					}
					answer.add(count);
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for (int i : answer)
			System.out.println(i);
	}
}