import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int T = sc.nextInt();
            String query = sc.next();
            String S = sc.next();
            int len = query.length();
            int count = 0;
             
            for (int j = 0; j <= S.length() - len; j++) {
                String s1 = S.substring(j, j + len);
                if (s1.equals(query)) count++;
            }
            System.out.println("#" + T + " " + count);
        }
    }
}