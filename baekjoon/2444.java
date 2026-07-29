import java.util.Scanner;

public class 2444 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		N = 2 * N - 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < Math.abs(i-N/2); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < N-2*Math.abs(i-N/2); j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		

	}

}
