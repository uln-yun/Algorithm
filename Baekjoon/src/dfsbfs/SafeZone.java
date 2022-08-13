package dfsbfs;

import java.util.*;
import java.io.*;

public class SafeZone {

	public static int n;
	public static int[][] graph = new int[100][100];
	
	public static boolean dfs(int x, int y, int[][] graph) {
		
		if (x < 0 || x >= n || y < 0 || y >= n) return false;
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
		n = Integer.parseInt(br.readLine());
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
				if (graph[i][j] > max) max = graph[i][j];
			}
		}
		
		int max_count = Integer.MIN_VALUE;
		for (int rain = 0; rain < max; rain++) {
			int[][] afterRain = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (graph[i][j] <= rain) {
						afterRain[i][j] = 0;
					} else {
						afterRain[i][j] = 1;
					}
				}
			}
			
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dfs(i, j, afterRain)) {
						count++;
					}
				}
			}
			
			if (max_count < count) {
				max_count = count;
			}
		}
		
		System.out.println(max_count);
	}

}
