package cw;

import java.util.Scanner;

public class Solution15651 {
	static int N;
	static int M;
	static int[] selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M];
		dfs(0);
	}
	
	static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++)
				System.out.print(selected[i]+" ");
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			selected[depth] = i;
			dfs(depth+1);
		}
	}
}
