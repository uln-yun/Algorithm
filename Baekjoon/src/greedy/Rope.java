package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rope {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ropes = new int[N];
		
		for (int i = 0; i < N; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ropes);
		
		for (int i = 0; i < N; i++) {
			ropes[i] *= N - i;
		}
		
		Arrays.sort(ropes);
		System.out.println(ropes[N-1]);
	}

}
