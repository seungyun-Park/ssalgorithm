package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class swea1204 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//T만큼 루프
		for(int i = 1; i <= T; i++) {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> arr = new ArrayList<>();
			
			while(st.hasMoreTokens()){
	            arr.add(Integer.parseInt(st.nextToken()));
	        }
			
			int[] count = new int[101];
			for(int j = 0 ; j < arr.size();j++) {
				count[arr.get(j)] += 1;
			}
			
			int max = -1;
			int maxIndex = -1;
			for(int j = 0 ; j <= 100;j++) {
				if(count[j] >= max) {
					max = count[j];
					maxIndex = j;
				}
			}
			
			System.out.println("#"+i+" "+ maxIndex);
		}
		
	}
}
