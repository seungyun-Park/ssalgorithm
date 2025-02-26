package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class swea1226 {
	public static void dfs(int x, int y, int dir) {
		if(grid[x][y] == 4)
			return;
		
		if(result == 1)
			return;
		//벽이면 return
		if(grid[x][y] == 1)
			return;
		//3이면 result = 1 하고 return
		if(grid[x][y] == 3) {
			result = 1;
			return;
		}
		grid[x][y] = 4;
		if(x - 1 >= 0 && x + 1 < 16 && y - 1 >= 0 && y + 1 < 16) {
			//상
			if(dir != 2) {
				dfs(x - 1, y, 1);
			}
			//하
			if(dir != 1) {
				dfs(x + 1, y, 2);
			}
			//좌
			if(dir != 4) {
				dfs(x, y - 1, 3);
			}
			//우
			if(dir != 3) {
				dfs(x, y + 1, 4);
			}
		}
	}
	
	static int[][] grid;
	static boolean[][] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int c = 1; c <= 1; c++) {
			result = 0;
			br.readLine();
			
			
			grid = new int[16][16];
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
			
			dfs(srcX, srcY, -5);
			
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

	
}
