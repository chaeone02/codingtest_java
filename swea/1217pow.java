import java.util.Scanner;
 
class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 10; t++) {
            int testCase = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println("#" + testCase + " " + power(N, M));
        }
    }
 
    static int power(int N, int M) {
        if (M <= 1) return N; //이건 M == 0 하는게 더 좋음
        else return N * power(N, M-1);
    }
}