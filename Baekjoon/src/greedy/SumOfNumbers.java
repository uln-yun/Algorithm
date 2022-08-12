package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOfNumbers {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		
		int i = 0;
		while (sum < S) {
			i++;
			sum += i;
		}
		
		if (sum == S) {
			System.out.println(i);
		} else {
			System.out.println(i-1);
		}
		
	}

}
