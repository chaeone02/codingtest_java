import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
             
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[] list = new int[N];
            for (int j = 0; j < N; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            for (int k = 2; k < N - 2; k++) {
                if ((list[k] - list[k-1]) >= 1 && (list[k] - list[k-2]) >= 1 && (list[k] - list[k+1]) >= 1 && (list[k] - list[k+2]) >= 1) {
                    int a = Math.min((list[k] - list[k-1]),(list[k] - list[k-2]));
                    int b = Math.min((list[k] - list[k+1]),(list[k] - list[k+2]));
                    answer += Math.min(a,b);
                }
            }
             
            System.out.println("#" + tc + " "+ answer);
        }
    }
}