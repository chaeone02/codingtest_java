import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;


class Ladder1210
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 0; tc < 10; tc++) {
            int answer = 0;
		    int[][] map = new int[100][100];
			int T = Integer.parseInt(br.readLine().trim());
			
			// map 만들기
			int X = 0; int Y = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						Y = i; X = j;
						}
				}
			}
			
			while (true) {
			    if (Y == 0) {
			        answer = X;
			        break;
			    }
                
			    // 왼쪽 길 있으면
			    if (X - 1 >= 0 && map[Y][X - 1] == 1) {
			        while (X - 1 >= 0 && map[Y][X - 1] == 1)  X--;
			    }
			    
			    // 오른쪽 길 있으면
			    else if (X + 1 < 100 && map[Y][X + 1] == 1) {
			        while (X + 1 < 100 && map[Y][X + 1] == 1) X++;
			    }
                
			    // 가로 이동을 했든 안 했든 한 칸 위로
			    Y--;
			}
			System.out.println("#" + T + " " + answer);
		}
	}
}