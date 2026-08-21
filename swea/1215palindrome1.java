import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static int len;
	static int answer;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			len = Integer.parseInt(br.readLine().trim());
			answer = 0;
			
			char[][] map = new char[8][8];
			
			for (int i = 0; i < 8; i++) {
				String line = br.readLine().trim();
				for (int j = 0; j < 8; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			// 가로 탐색
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8-len; j++) {
					boolean flag = false;
					for (int k = 0; k < len/2; k++) {
						if (map[i][j+k] == map[i][j+len-1-k])
							flag = true;
						else {
							flag = false;
							break;
						}
					}
					if (flag == true) answer++;
				}
			}

			// 세로 탐색
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8-len; j++) {
					boolean flag = false;
					for (int k = 0; k < len/2; k++) {
						if (map[j+k][i] == map[j+len-1-k][i])
							flag = true;
						else {
							flag = false;
							break;
						}
					}
					if (flag == true) answer++;
				}
			}
			System.out.println("#"+ tc+" "+answer);
		}
	}
}