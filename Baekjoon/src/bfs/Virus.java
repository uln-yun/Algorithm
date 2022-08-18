package bfs;

import java.io.*;
import java.util.*;

public class Virus {
	public static int n, edge;
	public static boolean[] visited;
	public static int count = 0;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static int bfs(int start) {
		count = 0;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int node = q.poll();
			
			for (int i = 0; i < graph.get(node).size(); i++) {
				int next = graph.get(node).get(i);
				
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		System.out.println(bfs(1));
	}

}
