package algo;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class mode {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int answer = -1;
		
		for (int i = 0; i < T; i++) {
			int tc = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] list = new int[1000];
			
			for (int j = 0; j < 1000; j++)
				list[j] = Integer.parseInt(st.nextToken());

			HashMap<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < 1000; j++) {
				if (map.containsKey(list[j])) { //해시맵 안에 해당 키가 있는지
					int temp;
					temp = map.get(list[j]);
					map.put(list[j], temp+1);
				}
				else
					map.put(list[j], 1);
			}
			
			int maxValue = Collections.max(map.values()); // 해시맵 values 중 최댓값 찾기
			for (Entry<Integer, Integer> entry : map.entrySet()) { // 해시맵 순회
			    if (entry.getValue() == maxValue)
			    	answer = Math.max(answer,entry.getKey());
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}