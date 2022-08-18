package bfs;

import java.io.*;
import java.util.*;

public class ParentNode {
	public static int n;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<Integer> parents = new ArrayList<>();

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(1);
		
		while (!q.isEmpty()) {
			int parent = q.poll();
			
			for (int i = 0; i < graph.get(parent).size(); i++) {
				int child = graph.get(parent).get(i);
				if (parents.get(child) == 0) {
					q.offer(child);
					parents.set(child, parent);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
			parents.add(0);
		}
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		bfs();
		
		for (int i = 2; i < n + 1; i++) {
			System.out.println(parents.get(i));
		}
	}

}
