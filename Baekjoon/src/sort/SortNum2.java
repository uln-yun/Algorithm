package sort;

import java.io.*;
import java.util.*;

public class SortNum2 {

	public static boolean[] arr = new boolean[2000001];
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		
		for (int i = 0; i < 2000001; i++) {
			if (arr[i]) sb.append(i - 1000000).append('\n');
		}
		System.out.print(sb);
	}

}
