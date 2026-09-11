package cw;

import java.util.Arrays;
import java.util.Scanner;

public class Solution15666 {

	static int N, M;
	static int[] selected;
	static int[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		selected = new int[M];
		Arrays.sort(list);
		dfs(0, 0);
	}
	
	static void dfs(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();
			return;
		}
		int prev = -1;
		for (int i = start; i < N; i++) {
			if (prev != list[i] ) {
				selected[depth] = list[i];
				prev = list[i];
				dfs(i, depth + 1);
			}
		}
	}
}