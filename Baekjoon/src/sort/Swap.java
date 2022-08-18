package sort;

import java.io.*;
import java.util.*;

public class Swap {
	public static int n, k;
	public static Integer[] arr_a, arr_b;
	public static int sum = 0;
			
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr_a = new Integer[n];
		arr_b = new Integer[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr_a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr_b[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr_a);
		Arrays.sort(arr_b, Collections.reverseOrder());
		
		for (int i = 0; i < 3; i++) {
			if (arr_a[i] < arr_b[i]) {
				int temp = arr_b[i];
				arr_b[i] = arr_a[i];
				arr_a[i] = temp;
			} else break;
		}
		
		for (int i = 0; i < n; i++) {
			sum += arr_a[i];
		}
		
		System.out.println(sum);
	}

}
