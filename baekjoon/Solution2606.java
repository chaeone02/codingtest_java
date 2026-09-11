package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2606 {

	static int C;
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[][] network;
	static Queue<Integer> queue;
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine().trim());
		N = Integer.parseInt(br.readLine().trim());
		visited = new boolean[C+1];
		graph = new ArrayList[C+1];
		
		for (int i = 1; i <= C; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			graph[start].add(dest);
			graph[dest].add(start);
		}
		
		queue = new ArrayDeque<>();
		count = 0;
		queue.offer(1);
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}