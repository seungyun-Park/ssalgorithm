package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea4193 {
	static int[][] dxdy = {{-1,0},{1,0},{0,-1},{0,1}};
	static int grid[][];
	static boolean visited[][];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cs = Integer.parseInt(br.readLine());
		for(int k = 1; k <= cs; k++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			int currentX = Integer.parseInt(st.nextToken());
			int currentY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int desX = Integer.parseInt(st.nextToken());
			int desY = Integer.parseInt(st.nextToken());
			
			
			System.out.println("#" + k + " " + bfs(currentX, currentY, desX, desY));
		}
	}
	
	
	public static int bfs(int x, int y, int desX, int desY) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		q.add(new int[] {x, y, 0});
		visited[x][y] = true;
//		System.out.println( " q0: " + q.peek()[0] + " q1: " + q.peek()[1] + " q2: " + q.peek()[2]);
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
//			System.out.println( "node[0] , node[1] , node[2] :" + node[0] + ", " + node[1] + ", " + node[2]);
			
			if(node[0] == desX && node[1] == desY) {
				return node[2];
			}
			
			for(int d[] : dxdy) {
				int nx = node[0] + d[0];
				int ny = node[1] + d[1];
				int ntime = node[2];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(!visited[nx][ny] && grid[nx][ny] != 1) {
						visited[nx][ny] = true;
						int wait = 2 - (ntime % 3);
						
						if(grid[nx][ny] == 2) {
							ntime = node[2] + wait;
							q.add(new int[] {nx, ny, ntime + 1});
						}
						else
							q.add(new int[] {nx, ny, ntime + 1});
						
					}
				}
			}
		}
		
		
		return -1;
	}
}	
