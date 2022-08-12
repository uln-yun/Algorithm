package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meetings, new Comparator<int[]>() {

			@Override
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[1] == arr2[1]) {
					return arr1[0] - arr2[0];
				} else {
					return arr1[1] - arr2[1];
				}
			}
		});
		
		int end_point = 0;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			if (end_point <= meetings[i][0]) {
				result++;
				end_point = meetings[i][1];
			}
		}
		
		System.out.println(result);
	}

}
