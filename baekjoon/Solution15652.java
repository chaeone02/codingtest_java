package cw;

import java.util.Scanner;

public class Solution15652 {

	static int N, M;
	static int[] selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M];
		dfs(1,0);

	}
	static void dfs(int start, int depth) {
		if (depth == M ) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			selected[depth] = i;
			dfs(i, depth + 1);
		}
	}

}