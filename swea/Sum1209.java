import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum1209 {

	public static void main(String[] args) throws Exception {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int tc = Integer.parseInt(br.readLine().trim());
			int[][] map = new int[100][100];
			int[] rowsum = new int[100];
			int[] colsum = new int[100];
			int diagsum = 0;
			int diag2sum = 0;
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int k = 0; k < 100; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
					rowsum[j] += map[j][k];
					colsum[k] += map[j][k];
					if (j == k) diagsum += map[j][k];
					else if (j + k == 99) diag2sum += map[j][k];
				}	
			}
			int nom = 0; int nom2 = 0;
			for (int n = 0; n < 100; n++) {
				nom = Math.max(nom,rowsum[n]);
				nom2 = Math.max(nom2,colsum[n]);
			}
			answer = Math.max(Math.max(nom,nom2),Math.max(diagsum,diag2sum));
			System.out.println("#" + tc + answer);
		}
	}
}
