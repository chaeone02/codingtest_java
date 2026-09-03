package cw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6603 {
	
	static int[] selected;
	static int k;
	static int[] S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			selected = new int[6];
			dfs(0,0);
			System.out.println();
		}
	}
	
	static void dfs(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < k; i++) {
			selected[depth] = S[i];
			dfs(i+1, depth+1);
		}
	}
}