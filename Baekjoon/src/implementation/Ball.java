package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ball {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] change = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			change[i][0] = Integer.parseInt(st.nextToken());
			change[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int cupWithBall = 1;
		for (int i = 0; i < N; i++) {
			if (change[i][0] == cupWithBall) {
				cupWithBall = change[i][1];
			} else if (change[i][1] == cupWithBall) {
				cupWithBall = change[i][0];
			}
		}
		
		System.out.println(cupWithBall);
	}

}
