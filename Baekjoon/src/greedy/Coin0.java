package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			
			if (K >= A[N-i-1]) {
				count += K / A[N-i-1];
				K %= A[N-i-1];
			} else {
				continue;
			}
		}
		System.out.println(count);
	}

}
