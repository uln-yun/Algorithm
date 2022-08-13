package dfsbfs;

import java.util.Scanner;

public class FreezeDrinks {
	
	public static int n, m;
	public static int[][] graph	= new int[1000][1000];
	
	public static boolean dfs(int x, int y) {
//		벗어나면 종료 
		if (x < 0 || x >= n || y < 0 || y >= m) {
			return false;
		}
		
//		해당 노드를 아직 방문하지 않았다면
		if (graph[x][y] == 0) {
//			해당 노드 방문 처리
			graph[x][y] = 1;
//			상, 하, 좌, 우 순차 호출
			dfs(x - 1, y);
			dfs(x + 1, y);
			dfs(x, y-1);
			dfs(x, y+1);
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		n, m을 공백으로 구분하여 입력받기
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dfs(i, j)) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
