import java.util.Arrays;

public class PermTest {

	static int [] p = {1,2,3,4,5};
	static int N,R, Count;
	static int [] nums;
	static boolean[] visited;
	
	public static void main(String[] args) {
		N = p.length;
		R = 3;
		//5p3 = 5!/(5-3)!
		nums = new int[R];
		visited = new boolean[N];
		Count = 0;
		perm(0);
		System.out.println(Count);

	}
	static void perm(int depth) {
		if (R == depth) {
			Count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[depth] = p[i];
			perm(depth+1);
			visited[i] = false;
			nums[depth] = 0;
		}
	}

}