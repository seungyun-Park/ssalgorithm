package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class swea1224 {
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int cs = 1; cs <= 10; cs++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			List<Character> list = new ArrayList<>();
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(isNum(ch)){
					list.add(ch);
				}
				if(isOperator(ch)) {
					if(stack.isEmpty()) {
						stack.push(ch);
					}
					else if(stack.lastElement() == '(') {
						stack.push(ch);
					}
					else if(ch == '(') {
						stack.push(ch);
					}
					else if(ch == '*') {
						stack.push(ch);
					}
					else if(ch == '+') {
						while (!stack.isEmpty() && stack.lastElement() != '(') { 
							list.add(stack.pop());
					    }
					    stack.push(ch);
					}
					else if(ch == ')') {
						char c;
						do {
							c = stack.pop();
							list.add(c);
						} while(c != '(');
						list.remove(list.size() - 1);
					}
					System.out.println(" stack : ");
					for (int j = 0; j < stack.size(); j++) {
						System.out.print(stack.elementAt(j) + " ");
					}
					System.out.println();
				}
				
				System.out.println(" list : ");
				for (int j = 0; j < list.size(); j++) {
					System.out.print(list.get(j) + " ");
				}
				System.out.println();
			}
			
			while (!stack.isEmpty()) {
			    list.add(stack.pop());
			}
			
			
			System.out.println("#" + cs + " " + calculate(list));
		}
	}
	
	public static boolean isNum(char ch) {
		if(ch >= '0' && ch <= '9') {
			return true;
		}
		else
			return false;
	}

	public static boolean isOperator(char ch) {
		if(ch == '+' || ch == '*' || ch == '(' || ch == ')') {
			return true;
		}
		return false;
	}
	
	public static int calculate(List<Character> list) {
		Stack<Integer> stk = new Stack<>();
		
		for (int i = 0; i < list.size(); i++) {
			char ch = list.get(i);
			if(isNum(ch)) {
				stk.push(Character.getNumericValue(ch));
			}
			if(isOperator(list.get(i))) {
				if(ch == '+') {
					stk.push(stk.pop() + stk.pop());
				}
				if(ch == '*') {
					stk.push(stk.pop() * stk.pop());
				}
			}
		}
		
		
		return stk.pop();
	}
}
