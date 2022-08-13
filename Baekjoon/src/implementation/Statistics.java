package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Statistics {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		
		int sum = 0;
		int[] counts = new int[8001];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
			counts[numbers[i] + 4000]++;
		}
		
		Arrays.sort(numbers);
		
		double mean = (double)sum / N;
		int median = numbers[N/2];
		int range = numbers[numbers.length-1] - numbers[0];
		
		int mode = 0;
		boolean flag = true;
		for (int i = 1; i < 8001; i++) {
			if (counts[i] > counts[mode]) {
				mode = i;
				flag = true;
			} else if (counts[i] == counts[mode]) {
				if (flag == true) {
					mode = i;
					flag = false;
				}
			}
		}
		
		System.out.println(Math.round(mean));
		System.out.println(median);
		System.out.println(mode - 4000);
		System.out.println(range);
	}

}
