package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=10; i++) {
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			List<Integer> arr = new ArrayList<>();
			while(st.hasMoreTokens()) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int j = 0; j < N; j++) {
				int max = arr.indexOf(Collections.max(arr));
				int min = arr.indexOf(Collections.min(arr));
				
				if(max - min == 0) {
					break;
				}
				
				arr.set(max, arr.get(max)-1);
				arr.set(min, arr.get(min)+1);
			}
			
			result = Collections.max(arr) - Collections.min(arr);
			
			
			System.out.println("#" + i + " " + result);
		}
		
	}
}
