import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine().trim());
			int answer = 0;
			char[][] map = new char[100][100];
			
			for (int i = 0; i < 100; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			// 가로 입력 회문
			for (int r = 0; r < 100; r++) { // 현재 행
				for (int i = 0; i < 100; i++) { // 회문 검사를 시작할 위치
					for (int j = answer + 1; j <= 100 - i; j++) { //검사할 문자열의 길이, i+j <= 100에 유의
						boolean flag = true;
						
						for (int k = 0; k < j/2; k++) { // 회문 검사 padding
							if (map[r][i+k] != map[r][i+j-1-k]) {
								flag = false;
								break;
							}
						} if (flag) {
							answer = Math.max(answer,j);
						}
					}
				}
			}
			
			// 세로 입력 회문
			for (int c = 0; c < 100; c++) {
				for (int i = 0; i < 100; i++) {
					for (int j = answer+1; j <= 100 - i; j++) {
						boolean flag = true;
						
						for (int k = 0; k < j/2; k++) {
							if (map[i+k][c] != map[i+j-1-k][c]) {
								flag = false;
								break;
							}
						} if (flag) {
							answer = Math.max(answer,j);
						}
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}