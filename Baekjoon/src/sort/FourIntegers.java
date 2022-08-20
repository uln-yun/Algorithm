package sort;

import java.io.*;
import java.util.*;

public class FourIntegers {
	public static ArrayList<Integer> arr1, arr2, arr_a, arr_b, arr_c, arr_d; 
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr_a.add(Integer.parseInt(st.nextToken()));
			arr_b.add(Integer.parseInt(st.nextToken()));
			arr_c.add(Integer.parseInt(st.nextToken()));
			arr_d.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr1.add(arr_a.get(i) + arr_b.get(j));
				arr2.add(-(arr_c.get(i) + arr_d.get(j)));
			}
		}
		
		Collections.sort(arr1);
		Collections.sort(arr2);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr2.add(arr_c.get(i) + arr_d.get(j));
			}
		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
			}
		}
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
	}

}
