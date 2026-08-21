import java.util.Scanner;

public class Subset4837 {
    static int N;
    static int K;
    static int answer;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            answer = 0;
            subset(1, 0, 0);

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void subset(int number, int count, int sum) {

    	// 종료 조건
        if (count == N) {
            if (sum == K) answer++;
            return;
        }
        if (number > 12) return;
        
        // 기본 로직
        // 현재 숫자를 선택하고 다음 차례로 넘김
        subset(number + 1, count + 1, sum + number);

        // 현재 숫자를 선택하지 않고 다음 차례로 넘김
        subset(number + 1, count, sum);
    }
}