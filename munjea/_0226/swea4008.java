package _0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea4008 {
	static int min;
	static int max;
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cs = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int c = 1; c <= cs; c++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			int[] op = new int[4]; // +, -, *, /
			st = new StringTokenizer(br.readLine());
			int i = 0;
			while(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				op[i] = n;
				i++;
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			dfs(op[0], op[1], op[2], op[3], new ArrayList<Character>());
	        
			int result = max - min;
			System.out.println("#" + c + " " + result);
		}//case
	}//main
	
	public static void dfs(int plus, int sub, int mul, int div, ArrayList<Character> ch) {
		if(ch.size() == N - 1) {
			max = Math.max(max, calculate(ch));
			min = Math.min(min, calculate(ch));
			return;
		}
		
		// +
		if(plus != 0) {
			ch.add('+');
			dfs(plus - 1, sub, mul, div, ch);
			ch.remove(ch.size() - 1);
		}
		// -
		if(sub != 0) {
			ch.add('-');
			dfs(plus, sub - 1, mul, div, ch);
			ch.remove(ch.size() - 1);
		}
		// *
		if(mul != 0) {
			ch.add('*');
			dfs(plus, sub, mul - 1, div, ch);
			ch.remove(ch.size() - 1);
		}
		// /
		if(div != 0) {
			ch.add('/');
			dfs(plus, sub, mul, div - 1, ch);	
			ch.remove(ch.size() - 1);
		}
	}//dfs
	
	
	public static int calculate(ArrayList<Character> ch) {
		int result = arr[0];
		
		for (int i = 0; i < ch.size(); i++) {
			if(ch.get(i) == '+') {
				result += arr[i + 1];
			}
			else if(ch.get(i) == '-') {
				result -= arr[i + 1];
			}
			else if(ch.get(i) == '*') {
				result *= arr[i + 1];
			}
			else if(ch.get(i) == '/') {
				result /= arr[i + 1];
			}
		}
		
		return result;
	}//calculate
	
}//swea4008
