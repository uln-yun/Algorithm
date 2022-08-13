package dfsbfs;

import java.util.*;

public class Numbering {
	
	public static int n;
	public static int[][] graph = new int[26][26];
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static int dfs(int x, int y) {
		int count = 0;
		if (x < 0 || x >= n || y < 0 || y >= n) return 0;
		if (graph[x][y] == 1) {
			graph[x][y] = 0;
			count++;
			count += dfs(x - 1, y);
			count += dfs(x + 1, y);
			count += dfs(x, y - 1);
			count += dfs(x, y + 1);
			return count;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int count = dfs(i, j);
				if (count > 0) result.add(count);
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
