package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			boolean goUp = true;
			boolean goRight = false;
			boolean goLeft = false;
			
			int[][] ladder = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int index = 0;
			for (int i = 0; i < 100; i++) {
				if(ladder[99][i] == 2) {
					index = i;
					break;
				}
			}
			
			int i = 99; int j = index;
			
			while(i != 0) {
				//위
				if(goUp) {
					i--;
					if( i == 0 )
						break;
					
					if( j != 99 && ladder[i][j+1] == 1) {
						goUp = false;
						goRight = true;
					}
					if( j != 0  && ladder[i][j-1] == 1) {
						goUp = false;
						goLeft = true;
					}
				}
				
				if(!goUp) {
					//오른쪽
					if(goRight) {
						j++;
						if(ladder[i + 1][j] == 1) {
							goUp = true;
							goRight = false;
						}
					}
					
					
					//왼쪽
					if(goLeft) {
						j--;
						if(ladder[i + 1][j] == 1) {
							goUp = true;
							goLeft = false;
						}
					}
					
				}
				
			}
			
			System.out.println("#" + t + " " + j);
		}
	}
}
