package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution15657 {

	static int N, M;
	static int[] num;
	static int[] selected;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		selected = new int[M];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		perm(0,0);
	}
	
	static void perm(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			selected[cnt] = num[i];
			perm(i, cnt + 1);
		}
	}
}
