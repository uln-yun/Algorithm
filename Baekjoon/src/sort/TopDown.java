package sort;

import java.io.*;
import java.util.Collections;
import java.util.Arrays;

public class TopDown {
	public static Integer[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
