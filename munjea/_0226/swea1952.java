package _0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1952 {
	static int min;
	static int[] cost;
	static int[] plan;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cs = Integer.parseInt(br.readLine());
		
		for (int c = 1; c <= cs; c++) {
			min = Integer.MAX_VALUE;
			cost = new int[4];
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			//입력
			
			
			dfs(0,0);
			
			
			System.out.println("#" + c + " " + min);
		}//case
		
	}//main
	
	public static void dfs(int idx, int count) {
		if(idx >= 12) {
			min = Math.min(min, count);
			return;
		}
		
		//1일 이용권
		dfs(idx + 1, count + plan[idx]*cost[0]);
		
		//1달 이용권
		dfs(idx + 1, count + cost[1]);
		
		//3달 이용권
		dfs(idx + 3, count + cost[2]);
		
		//1년 이용권
		dfs(idx + 12, count + cost[3]);
	}//dfs
	
}//swea1952
