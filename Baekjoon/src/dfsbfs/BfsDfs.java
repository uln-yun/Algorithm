package dfsbfs;

import java.io.*;
import java.util.*;

public class BfsDfs {
	public static int n, m, v;
	public static boolean[] visitedDFS = new boolean[1001];
	public static boolean[] visitedBFS = new boolean[1001];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void dfs(int x) {
		if (visitedDFS[x] == false) {
			visitedDFS[x] = true;
			System.out.print(x + " ");
			for (int i = 0; i < graph.get(x).size(); i++) {
				dfs(graph.get(x).get(i));
			}
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		
		while (!q.isEmpty()) {
			int node = q.poll();
			if (visitedBFS[node] == false) {
				System.out.print(node + " ");
				visitedBFS[node] = true;
				for (int i = 0; i < graph.get(node).size(); i++) {
					q.offer(graph.get(node).get(i));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 0; i < n + 1; i++) {
			Collections.sort(graph.get(i));
		}
		
		dfs(v);
		System.out.println();
		bfs(v);
	}

}
