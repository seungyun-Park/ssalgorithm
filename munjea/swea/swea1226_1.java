package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea1226_1 {
	static int[][] grid;
	static boolean[][] visited;
	static int[][] dxdy = {{0,-1},{0,1},{-1,0},{1,0}};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int c = 1; c <= 10; c++) {
			result = 0;
			br.readLine();
			
			grid = new int[16][16];
			visited = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < 16; j++) {
					grid[i][j] = Character.getNumericValue(tmp.charAt(j));
				}
			}
			
			//출발, 도착점 찾기
			int srcX, srcY, desX, desY;
			int[] x = checkThePoint(grid);
			srcX = x[0]; srcY = x[1]; desX = x[2]; desY = x[3];
			
			bfs(srcX, srcY);
			
			System.out.println("#" + c + " " + result);
		}
	}
	public static int[] checkThePoint(int[][] grid) {
		int srcX = 0;
		int srcY = 0;
		int desX = 0;
		int desY = 0;
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				if(grid[i][j] == 2) {
					srcX = i;
					srcY = j;
				}
				if(grid[i][j] == 3) {
					desX = i;
					desY = j;
				}
			}
		}
		int[] x = new int[4];
		x[0] = srcX; x[1] = srcY; x[2] = desX; x[3] = desY;
		return x;
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] node = q.poll();
			visited[node[0]][node[1]] = true;
			for(int[] d : dxdy) {
				int nx = node[0] + d[0], ny = node[1]+d[1];
				
				if(!visited[nx][ny]) {
					if(grid[nx][ny] == 0) {
						q.add(new int[] {nx, ny});
					}
					if(grid[nx][ny] == 3) {
						result = 1;
						return;
					}
				}
			}
		}
		
	}
}
