package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea1234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int k = 1; k <= 10 ;k++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < length; i++) {
				char ch = str.charAt(i);
				if(stack.size() == 0) {
					stack.push(str.charAt(i));
				}
				else {
					if(ch == stack.lastElement()) {
						stack.pop();
					}
					else {
						stack.push(str.charAt(i));
					}
				}
			}
			String ans = "";
			for (int i = 0; i < stack.size(); i++) {
				ans += stack.elementAt(i);
			}
			System.out.println("#" + k + " " + ans);
		}
	}
	
}
