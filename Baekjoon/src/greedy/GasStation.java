// Long과 int의 차이: int는 2,147,483,647까지 저장 가능. (4바이트)

package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] distance = new long[N-1];
		for (int i = 0; i < N-1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		long[] gasPrice = new long[N];
		for (int i = 0; i < N; i++) {
			gasPrice[i] = Integer.parseInt(st1.nextToken());
		}
		
		long result = 0;
		long minimumGasPrice = gasPrice[0];
		for (int i = 0; i < N-1; i++) {
			minimumGasPrice = Math.min(minimumGasPrice, gasPrice[i]);
			result += minimumGasPrice * distance[i];
		}
		
		System.out.println(result);
	}

}
