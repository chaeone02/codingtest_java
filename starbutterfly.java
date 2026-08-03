import java.util.Scanner;

public class starbutterfly {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for (int tc = 1; tc <= T; tc++) {
    		int N = sc.nextInt();
    		int mid = N / 2;
        System.out.println("#" + tc);
        
    		for(int i = 0; i < N; i++) {
    			int d = Math.abs(i- mid);
    			int star = mid - d + 1;
    			int space = 2*d - 1;
    			
    			for(int j = 0; j < star; j++) {
    				System.out.print('*'); 
    			}
          
    			if (d != 0) {
    				for(int j = 0; j < space; j++)
    					System.out.print(" ");
    			
    				for(int j = 0; j < star; j++)
    					System.out.print('*');
    			}
    			else {
    				for(int j = 1; j < star; j++) 
    				System.out.print('*');
    			}
        		System.out.println();
    		}
		}
  }
}
