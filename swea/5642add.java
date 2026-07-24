import java.util.*;
import java.io.*;
  
class Solution
{
    static int T, N;
    static int[] kad;
    public static void main(String args[]) throws Exception
    {
        // System.in 으로 입력이 들어옴 -> I.S.R가 문자 형태로 반환, B.R가 모아서 빠르게 읽음
        //                         (빨대)      (숫자를 char로 바꿔서 한번에 보내줄게)  (수도꼭지)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null; //한 줄에 공백으로 구분된 값 나누기
        T= Integer.parseInt(br.readLine());
          
        for (int tc = 1; tc <= T; tc++) {
            N =Integer.parseInt(br.readLine());
            kad = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                kad[i] = Integer.parseInt(st.nextToken().trim());
              
            int curSum = kad[0];
            int maxSum = kad[0];
              
      
            for (int i = 1; i < N; i++) {
                // 이전합 버리고 지금부터 시작하는 경우 vs 이전합에 현재값 이어붙이는 경우
                curSum = Math.max(kad[i], curSum + kad[i]); //현재부터 시작하는 수열의 최댓값
                maxSum = Math.max(maxSum, curSum); // 전체 수열 중 최댓값
            }
              
            System.out.println("#" + tc + " " + maxSum);
        }
    }
}