//강사님 코드
import java.util.*;
import java.io.*;

public class swimming
{
    static int T;
    static int N;
    static int[][] maps;
    static boolean[][] visited;
    static int A, B, C, D;
    static int result;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++)
		{
			N = Integer.parseInt(br.readLine().trim());
            maps = new int[N][N];
            StringTokenizer st = null;

            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < N; j++)
            		maps[i][j] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            // 시작점
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            
            
            boolean isS = bfs();
            System.out.println("#" + tc + " " + (isS?result:-1));
            
		}
	}
	
	static boolean bfs() {
		Queue<int[]> points = new LinkedList<>();
		points.offer(new int[] {A,B});
		maps[A][B] = 1; //시작점 거리를 1로 0이면 갈수 있음, 1이상이면 못가
		while(!points.isEmpty()) {
			int[] p = points.poll();
			int r = p[0]; int c = p[1];
			if(C==r & D==c) {
				result = maps[r][c] - 1;
				return true;
			}
			// 4방이동 & 체크
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(! check(nr, nc)) continue;
				if(maps[nr][nc]>= 1) continue;
				points.offer(new int[] {nr,nc});
				maps[nr][nc] = maps[r][c]+1;
			}
		}
		return false; // 도착 못함
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c>= 0 && c < N;
	}
}