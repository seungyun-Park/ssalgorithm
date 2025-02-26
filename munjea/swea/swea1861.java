package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1861 {
	static int max = 0;
	static int[][] dxdy = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //상하좌우
	static int[][] grid;
	static int N;
	static int finalNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cs = Integer.parseInt(st.nextToken());
		
		//테스트 케이스
		for(int k = 1; k <= cs; k++) {
			max = 0;
			finalNode = 0;
			N = Integer.parseInt(br.readLine());
			
			grid = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			for (int i = 1; i <= N*N; i++) {
				dfs(i, 1);
			}
			
			
			System.out.println("#" + k + " " + finalNode + " " +max);
		}
	}
	
	
	public static void dfs(int node, int count) {
		int x = -1, y = -1;
		if(count > max) {
			finalNode = node - count + 1;
			max = Math.max(max, count);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(node == grid[i][j]) {
					x = i;
					y = j;
					break;
				}
			}
		}
		
		for(int[] d : dxdy) {
			if(x+d[0] >= 0 && y+d[1] >= 0 && x+d[0] < N && y+d[1] < N) {
				if(grid[x+d[0]][y+d[1]] == node + 1) {
					dfs(grid[x+d[0]][y+d[1]], count + 1);
				}
			}
		}
	}
}
