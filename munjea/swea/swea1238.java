package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1238 {
	static int[][] arr;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int cs = 1; cs <= 10; cs++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int startNode = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[N/2][2];
			visited = new boolean[101];
			for (int i = 0; i < N/2; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			
			System.out.println("#" + cs + " " + bfs(startNode));
		}
		
		
		
	}
	
	public static int bfs(int startNode) {
		Queue<int[]> q = new LinkedList<>();
		int turn = 1;
		
		for (int i = 0; i < N/2; i++) {
			if(startNode == arr[i][0] && !visited[arr[i][1] - 1]) {
				q.add(new int[] {arr[i][0] , arr[i][1], turn});
			}
		}
		int[] node;
		int max = 0;
		int maxTurn = 0;
		
		while(!q.isEmpty()) {
			node = q.poll();
			visited[node[0] - 1] = true;
			if(maxTurn < node[2]) {
				maxTurn = node[2];
				max = 0;
			}
			if(!visited[node[1] - 1]) {
				visited[node[1] - 1] = true;
				boolean hasNeighbor = false;
				for (int i = 0; i < N/2; i++) {
					if(node[1] == arr[i][0] && !visited[arr[i][1] - 1]) {
						q.add(new int[] {arr[i][0] , arr[i][1] , node[2] + 1});
						hasNeighbor = true;
					}
				}
				if(!hasNeighbor && maxTurn == node[2]) {
					max = Math.max(node[1], max);
				}
			}
		}
		
		
		return max;
	}
}