// 못풀음......
package dfsbfs;

import java.util.*;
import java.io.*;

public class BipartiteGraph {

	public static int k;
	
    public static boolean dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph, int[] team) {
        // 현재 노드를 방문 처리
        visited[node] = true;
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
//        for (int i = 0; i < graph.get(node).size(); i++) {
//            int y = graph.get(x).get(i);
//            if (!visited[y]) dfs(y);
            
    		for (int i = 0; i < graph.get(node).size(); i++) {
    			int nextNode = graph.get(node).get(i);
    			if (visited[nextNode] == false) {
    				if (team[nextNode] == team[node]){
        				return false;
        			} else if (team[nextNode] == 0) {
        				team[nextNode] = -team[node];
        				if (!dfs(nextNode, visited, graph, team)) return false;
        			}
//        			if (!dfs(nextNode, visited, graph, team)) return false;
    			} else {
    				if (team[nextNode] == team[node]){
        				return false;
        			}
    			}
    		}
    		return true;
        }
//    }
    
//	public static boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] team) {
//		System.out.println(node);
//		for (int i = 0; i < graph.get(node).size(); i++) {
//			int nextNode = graph.get(node).get(i);
//			System.out.println(node + " " + nextNode);
//			if (team[nextNode] == team[node]){
//				System.out.println("case1" + " " + nextNode + " " + team[nextNode]);
//				return false;
//			} else if (team[nextNode] == 0) {
//				team[nextNode] = -team[node];
//				System.out.println("case2" + " " + nextNode + " " + team[nextNode]);
//				if (!dfs(nextNode, graph, team)) return false;
//			}
//			if (!dfs(nextNode, graph, team)) return false;
//			System.out.println("case3" + " " + nextNode + " " + team[nextNode] + " " + team[node]);
//		}
//		return true;
//	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < k; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			// 그래프 작성 
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			for (int node = 0; node < v+1; node++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for (int edge = 0; edge < e; edge++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				graph.get(A).add(B);
				graph.get(B).add(A);
			}
			
			for (int node = 0; node < v+1; node++) {
				Collections.sort(graph.get(node));
			}
			
			if (v == 1) {
				System.out.println("NO");
				continue;
			}
			
			boolean[] visited = new boolean[v+1];
			String answer = "YES";
			int[] team = new int [v+1];
			team[1] = 1;
			for (int i = 1; i <= v; i++) {
				if (i == 1 || team[i] == 0) {
					if (!dfs(i, visited, graph, team)) {
						answer = "NO";
						break;
					}
				}
			}
			System.out.println(answer);
		}

	}

}
