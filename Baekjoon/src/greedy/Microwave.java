package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Microwave {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] btnSec = {300, 60, 10};
		int[] btnCnt = new int[3];
		
		for (int i = 0; i < 3; i++) {
			btnCnt[i] = T / btnSec[i];
			T %= btnSec[i];
		}
		
		if (T > 0) System.out.println(-1);
		else {
			for (int i = 0; i < 3; i++) {
				System.out.print(btnCnt[i] + " ");
			}
		}
	}

}
