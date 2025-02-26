package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Magnetic {
	int x;
	int y;
	int pole;
	
	Magnetic(int i,int j, int pole){
		this.x = i;
		this.y = j;
		this.pole = pole;
	}
}

public class swea1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int k = 1; k <= 10; k++) {
			int[][] grid = new int[100][100];
			
			String q = br.readLine();

			List<Magnetic> mgList = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());	
					if(grid[i][j] != 0){
						mgList.add(new Magnetic(i, j, grid[i][j]));
					}			
				}
			}
			
			//1이 N , 2가 S
			
			boolean moved = true;
			while(moved) {
				List<Magnetic> nextMgList = new ArrayList<>();
				moved = false;
				
				for (Magnetic mag : mgList) {
					int nx = mag.x;
					//N
					if(mag.pole == 1) {
						if(mag.x == 99) {
							moved = true;
							continue;
						}
						if(mag.x + 1 < 100 && grid[mag.x + 1][mag.y] == 0) {
							nx = mag.x + 1; 
							moved = true;
						}
					}
					
					//S
					if(mag.pole == 2) {
						if(mag.x == 0) {
							moved = true;
							continue;
						}
						
						if(mag.x - 1 >= 0 && grid[mag.x - 1][mag.y] == 0) {							
							nx = mag.x - 1; 
							moved = true;
						}
					}
					
					nextMgList.add(new Magnetic(nx,mag.y,mag.pole));
				}
			
				grid = new int[100][100];
					
				for (Magnetic mag : nextMgList) {
					grid[mag.x][mag.y] = mag.pole;
				}
			}
			
			for(int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					System.out.print(grid[i][j] + " "); 
				}
				System.out.println();
			}
			
			int count = 0;
			boolean meet = false;
			for(int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(grid[j][i] == 1 && meet == false) {
						meet = true;
					}
					else if(grid[j][i] == 2 && meet == true) {
						meet = false;
						count++;
					};
				}
				meet = false;
			}
			
			System.out.println("#" + k + " " + count);
		}

	}

}
