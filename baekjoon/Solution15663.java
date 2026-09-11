package cw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution15663 {

	static int N, M;
	static int[] selected;
	static boolean[] visited;
	static int[] list;
	static ArrayList<int[]> check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		list = new int[N];
		check = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		selected = new int[M];
		visited = new boolean[N];
		dfs(0);
	}
	static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i] + " ");
			}
	        System.out.println();
	        return;
		}
		int prev = -1;

		for (int i = 0; i < N; i++) {
			if (!visited[i] && prev != list[i]) {
				visited[i] = true;
				selected[depth] = list[i];
				prev = list[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}