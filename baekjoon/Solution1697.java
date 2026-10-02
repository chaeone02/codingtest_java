package cw;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution1697 {

	static int N, K;
	static int[] map;
	static int[] visited;
	static int answer = 0;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int [100001];
		visited = new int[100001];
		q = new ArrayDeque<>();
		q.offer(N);
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == K) {
				answer = visited[x];
				break;
			}
			if (x-1 >= 0 && visited[x-1] == 0) {
				q.offer(x-1);
				visited[x-1] = visited[x] + 1;
			}
			if(x+1 < 100001 && visited[x+1] == 0) {
				q.offer(x+1);
				visited[x+1] = visited[x] + 1;
			}
			if(x*2 < 100001 && visited[x*2] == 0) {
				q.offer(x*2);
				visited[x*2] = visited[x] + 1;
			}
		
		}
		System.out.println(answer);
	}
	
}
