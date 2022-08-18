package bfs;

import java.util.*;
import java.io.*;

class Mode {
	private int x, y;
	
	public Mode(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
public class Tomato {
	
	public static int n, m;
	public static int[][] graph = new int[1001][1001];
	public static int[][] ripenTime = new int[1001][1001];
	public static Queue<Mode> q = new LinkedList<>();
	public static boolean allRipe;
	public static int count;
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void bfs() {
		while (!q.isEmpty()) {
			Mode node = q.poll();
			int x = node.getX();
			int y = node.getY();
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
				if (graph[nx][ny] == 0 && ripenTime[nx][ny] == 0) {
					ripenTime[nx][ny] = ripenTime[x][y] + 1;
					q.offer(new Mode(nx, ny));
				}
			}
			count++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		allRipe = true;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				graph[i+1][j+1] = Integer.parseInt(st.nextToken());
				if (graph[i+1][j+1] == 0) allRipe = false;
			}
		}
		
		if (allRipe) System.out.println(0);
		else {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (graph[i][j] == 1) q.offer(new Mode(i, j));
				}
			}
			
			bfs();
			
			allRipe = true;
			int maximum = Integer.MIN_VALUE;
			Loop1:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (graph[i][j] == 0 && ripenTime[i][j] == 0) {
						allRipe = false;
						break Loop1;
					} else if (ripenTime[i][j] > maximum) {
						maximum = ripenTime[i][j];
					}
				}
			}
			
			if (!allRipe) System.out.println(-1);
			else System.out.println(maximum);
		}
	}

}

