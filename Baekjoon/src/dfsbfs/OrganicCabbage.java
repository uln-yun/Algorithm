//DFS
package dfsbfs;

import java.util.*;
import java.io.*;

public class OrganicCabbage {
	public static int t;
	
	public static boolean dfs(int x, int y, int[][] graph) {
		if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length) return false;
		if (graph[x][y] == 1) {
			graph[x][y] = 0;
			dfs(x - 1, y, graph);
			dfs(x + 1, y, graph);
			dfs(x, y - 1, graph);
			dfs(x, y + 1, graph);
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
					
			int[][] graph = new int[50][50];
			
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}
			
			int count = 0;
			for (int x = 0; x < m; x++) {
				for (int y = 0; y < n; y++) {
					if (dfs(x, y, graph)) count++;
				}
			}
			
			System.out.println(count);
		}
	}
}
