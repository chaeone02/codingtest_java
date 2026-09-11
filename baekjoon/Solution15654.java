package cw;

import java.util.Arrays;
import java.util.Scanner;

public class Solution15654 {

	static int N, M;
	static int[] selected;
	static boolean[] visited;
	static int[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M];
		visited = new boolean[N];
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
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
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = list[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}