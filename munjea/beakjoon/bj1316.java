package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj1316 {
	
	public static boolean isGroupWord(String word) { //그룹단어인지 판별하는  함수
		boolean[] visited = new boolean[26];
		
        char prev = word.charAt(0); 
        visited[prev - 'a'] = true;

        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);

            if (current != prev) {  // 연속된 문자 아닐 때
                if (visited[current - 'a']) {  // 이전에 등장했으면 그룹단어가 아님
                    return false;
                }
                visited[current - 'a'] = true; 
            }
            prev = current;
        }
        return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<String> words = new ArrayList<String>();
		
		for(int i =0; i< N; i++) {
			String str = br.readLine();
			words.add(str);
		}
		
		int count = 0;
		for(String word : words) {
			if(isGroupWord(word)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}