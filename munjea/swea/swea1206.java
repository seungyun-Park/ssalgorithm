package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class swea1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//10번 루프
		for(int i=1; i <= 10; i++) {
			
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			

			for(int j = 2; j < N-2; j++) {
				int a,b,c,d;
				a = arr[j] - arr[j-2];
				b = arr[j] - arr[j-1];
				c = arr[j] - arr[j+1];
				d = arr[j] - arr[j+2];

				if(a > 0 && b > 0  && c > 0 && d > 0){
					result += Math.min(a, Math.min(b, Math.min(c, d)));
				}
			}
			
			
			
			
			System.out.println("#"+i+" "+result);
		}
		
	}
}
