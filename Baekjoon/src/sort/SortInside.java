package sort;

import java.io.*;

public class SortInside {

	public static int[] arr = new int[10];
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - '0']++;
		}
		
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < arr[i]; j++) {
				sb.append(i);
			}
		}
		System.out.println(sb);
	}

}
