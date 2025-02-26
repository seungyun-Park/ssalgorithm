package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1219 {
	static int[] map1;
	static int[] map2;
	static int result;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//10개
		for (int k = 1; k <= 10; k++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			//순서쌍
			st = new StringTokenizer(br.readLine());
			
			map1 = new int[100];
			map2 = new int[100];
			
			while(st.hasMoreTokens()) {
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				
				if(map1[n1] == 0) {
					map1[n1] = n2;
				}
				else {
					map2[n1] = n2;
				}
			}
			
			dfs(0);
			
			
			System.out.println("#" + k + " " + result);
		}
	}
	
	
	public static void dfs(int node) {
		if(node == 99) {
			result = 1;
			return;
		}
		
		//map1 선택
		if(map1[node] != 0) {
			dfs(map1[node]);
		}
		
		//map2 선택
		if(map2[node] != 0) {
			dfs(map2[node]);
		}
	}
}
