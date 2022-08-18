package sort;

import java.io.*;
import java.util.*;

public class LowGrade {
	
	public static final int MAX_SCORE = 100;
	public static ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < MAX_SCORE; i++) {
			arr.add(new ArrayList<String>());
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			arr.get(score).add(name);
		}
		
		for (int i = 0; i < MAX_SCORE; i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {
				System.out.print(arr.get(i).get(j) + " ");
			}
		}
	}

}
