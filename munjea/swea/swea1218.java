package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class swea1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int k = 1; k <= 10 ;k++) {
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] arr = new char[length];
			int result = 0;
			
			for (int i = 0; i < length; i++) {
				arr[i] = str.charAt(i);
			}

			List<Character> list = new ArrayList<>();
			
			for (int i = 0; i < length; i++) {
				if(checkOpen(arr[i])) {
					list.add(arr[i]);
				}
				if(checkClose(arr[i])) {
					boolean check = removePair(arr[i], list);
					if(!check)
						break;
				}
			}
			
			if(list.isEmpty()) {
				result = 1;
			}
			
			System.out.println("#" + k + " " + result);
		}
	}
	
	
	public static boolean checkOpen(char ch) {
		if(ch == '(' || ch == '{'|| ch == '[' || ch == '<') {
			return true;
		}
		return false;
	}
	
	public static boolean checkClose(char ch) {
		if(ch == ')' || ch == '}'|| ch == ']' || ch == '>') {
			return true;
		}
		return false;
	}
	
	public static boolean removePair(char ch, List<Character> list) {
		boolean bl = true;
		
		if(ch == ')' && list.get(list.size() - 1) == '(' ) {
			list.remove(list.lastIndexOf('('));
		}
		else if(ch == '}' && list.get(list.size() - 1) == '{') {
			list.remove(list.lastIndexOf('{'));
		}
		else if(ch == ']' && list.get(list.size() - 1) == '[') {
			list.remove(list.lastIndexOf('['));
		}
		else if(ch == '>' && list.get(list.size() - 1) == '<') {
			list.remove(list.lastIndexOf('<'));
		}
		else return false;
		
		return bl;
	}
	
}
