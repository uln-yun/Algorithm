package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Change {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int change = 1000 - Integer.parseInt(br.readLine());
		int[] bills = new int[] {500, 100, 50, 10, 5, 1};
		
		int result = 0;
		for (int i = 0; i < 6; i++) {
			result += change / bills[i];
			change = change % bills[i];
		}
		
		System.out.println(result);
	}

}
