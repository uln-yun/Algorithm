package bfs;

import java.util.*;
import java.io.*;

class Node {
	private int x;
	private int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
public class MazeExploration {
	
	public static int n, m;
	public static int[][] shortest = new int[101][101];
	public static int[][] graph = new int[101][101];
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static int bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			int x = node.getX();
			int y = node.getY();
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
				if (graph[nx][ny] == 0) continue;
				if (shortest[nx][ny] == 0) {
					shortest[nx][ny] = shortest[x][y] + 1;
					q.offer(new Node(nx, ny));
				}
			}
		}
		
		return shortest[n][m];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i+1][j+1] = Character.getNumericValue(row.charAt(j));
			}
		}
		
		shortest[1][1] = 1;
		System.out.println(bfs(new Node(1, 1)));
	}

}
