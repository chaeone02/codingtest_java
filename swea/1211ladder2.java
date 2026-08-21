import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int T = Integer.parseInt(br.readLine().trim());
            int[][] maps = new int[100][100];
            int[] starts = new int[100];
            int dist = Integer.MAX_VALUE;
            int result = 0;
             
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < 100; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 0 && maps[i][j] == 1) {
                        starts[j] = 1;
                    }
                }
            }
                 
            for (int k = 0; k < 100; k++) {
                int X = 0; int Y = 0;
                int count = 0;
                if (starts[k] == 1) {
                    X = k;
                    while (true) {
                        if (Y == 99) break;
                             
                        if ((X-1 >= 0) && maps[Y][X-1] == 1) {
                            while ((X-1 >= 0) && maps[Y][X-1] == 1) {
                                X--;
                                count++;
                            }
                        }
                        else if ((X+1 < 100) && maps[Y][X+1] == 1) {
                            while ((X+1 < 100) && maps[Y][X+1] == 1) {
                                X++;
                                count++;
                            }
                        }
                        Y++;
                        count++;
                    }
                    if (count <= dist) {
                        dist = count;
                        result = k;
                    }
                }
            }
            System.out.println("#"+T+" "+result);
        }
    }
}