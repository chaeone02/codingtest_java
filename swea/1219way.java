import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static int[] data1;
	static int[] data2;
	static boolean[] visited;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 데이터 저장 로직
		for (int i = 0; i < 10; i++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int tc = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			data1 = new int[100];
			data2 = new int[100];
			visited = new boolean[100]; // change: 무한 반복 하지 않도록
			flag = false;
			
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < len; j++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if (data1[start] == 0) data1[start] = end;
				else data2[start] = end;
			}
			
			//2. 탐색 로직
			dfs(0); // change: 정점 0부터 찾도록
			if (flag) answer = 1;
			
			System.out.println("#"+tc+" "+answer);
		}		
	}

	static void dfs(int n) {
		if (visited[n]) return;
		visited[n] = true;
		
		if (n == 99) { // change: 다음 정점을 검사하지 않도록 주의
			flag = true;
			return;
		}
		if (data1[n] != 0) {
			dfs(data1[n]);
		}
		if (data2[n] != 0) {
			dfs(data2[n]);
		}
	}
}