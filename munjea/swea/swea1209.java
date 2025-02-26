package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class swea1209 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int k = 1; k <= 10; k++) {
			int T = Integer.parseInt(br.readLine());
			int[][] grid = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
		
		
	    int max = 0;
    	int sum = 0;
	    
	    for (int i = 0; i < 100; i++) {
	    	sum = 0;
			for (int j = 0; j < 100; j++) {
				sum += grid[i][j];
			}
			max = Math.max(sum, max);
		}
	    
	    for (int i = 0; i < 100; i++) {
	    	sum = 0;
			for (int j = 0; j < 100; j++) {
				sum += grid[j][i];
			}
			max = Math.max(sum, max);
		}
	    
	    sum = 0;
	    for (int j = 0; j < 100; j++) {
			sum += grid[j][j];
		}
		max = Math.max(sum, max);
		
		sum = 0;
	    for (int j = 0; j < 100; j++) {
			sum += grid[j][99-j];
		}
		max = Math.max(sum, max);
	    
		System.out.println("#" + k + " " + max);
		}
	}
}
