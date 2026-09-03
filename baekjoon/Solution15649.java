package cw;

import java.util.Scanner;

public class Solution15649 {

	static int[] selected;
	static boolean[] visited;
	static int N, M;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M];
		visited = new boolean[N];
		dfs(0);
	}
	
	static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = i;
				dfs(depth+1);
				visited[i] =false;
			}
		}
	}
}