package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ATM {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(p);
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += p[i] * (n - i);
		}
		System.out.println(sum);
	}

}
