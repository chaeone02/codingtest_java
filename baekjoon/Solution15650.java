package cw;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution15650 {

	static int[] selected;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		selected = new int[M];
		dfs(1,0);

	}
	static void dfs(int start, int depth) {
		if (depth == M) {
			// 조합 만들어짐, 리스트에 넣기
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();
			return;
		}
		// start부터 N까지 숫자를 하나씩 후보로 보고,
		// 그 숫자를 현재 자리(depth)에 넣고,
		// 다음 자리에는 지금 고른 숫자보다 큰 숫자부터 고르러 감.
		for (int i = start; i <= N; i++) {
			selected[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}
}