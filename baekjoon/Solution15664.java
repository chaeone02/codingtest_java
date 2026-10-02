package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution15664 {

	static int N, M;
	static int[] num;
	static int[] selected;
	static int[] prev;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		selected = new int[M];
		prev = new int[M];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		comb(0,0);

	}
	

	static void comb(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();
			return;
		}
		// 재귀호출마다 새로 만들도록 해야함!!
		int prev = -1;
		
		for (int i = start; i < N; i++) {
			if (prev == num[i]) continue;
			prev = num[i];
			selected[depth] = num[i];
			comb(i+1, depth+1);
		}
	}
}
