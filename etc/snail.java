import java.util.Scanner;

public class snail {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int x = 0; int y = 0;
			int d = 0;d
			
			for(int i = 1 ; i <= N * N; i++) {
				arr[y][x] = i;
				
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || arr[ny][nx] != 0) {
					d = (d+1) % 4;
					ny = y + dy[d];
					nx = x + dx[d];
				}
				y = ny;
				x = nx;
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + "	");
				}
				System.out.println();
			}
		}
	}
}
