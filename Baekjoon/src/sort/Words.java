package sort;

import java.io.*;
import java.util.*;

public class Words {

	public static ArrayList<String> arr;
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(br.readLine());
		}
		
		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() < o2.length()) {
					return -1;
				} else {
					for (int i = 0; i < o1.length(); i++) {
						if (o1.charAt(i) - o2.charAt(i) != 0) {
							return o1.charAt(i) - o2.charAt(i);
						}
						else continue;
					}
				}
				return 0;
			}
			
		});
		
		for (int i = 0; i < n; i++) {
			if (i > 0 && arr.get(i).equals(arr.get(i - 1))) continue;
			System.out.println(arr.get(i));
		}
	}

}
